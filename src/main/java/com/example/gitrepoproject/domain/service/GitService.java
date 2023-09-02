package com.example.gitrepoproject.domain.service;

import com.example.gitrepoproject.domain.proxy.*;
import com.example.gitrepoproject.domain.proxy.dto.BranchResult;
import com.example.gitrepoproject.domain.proxy.dto.GitAndBranchResponse;
import com.example.gitrepoproject.domain.proxy.dto.GitAndBranchResult;
import com.example.gitrepoproject.domain.proxy.dto.GitResult;
import com.example.gitrepoproject.validation.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class GitService {


    GitProxy gitClient;

    GitMapper gitMapper;


    public GitService(GitProxy gitClient, GitMapper gitMapper) {
        this.gitClient = gitClient;
        this.gitMapper = gitMapper;
    }

    public List<GitResult> fetchAllRepos(String username) {
        try {
            String json = gitClient.makeGetRequest(username);
            return gitMapper.mapJsonToGitResponse(json).stream()
                    .filter(gitResultWithFork -> !gitResultWithFork.fork())
                    .map(gitResultWithFork -> new GitResult(gitResultWithFork.name(), gitResultWithFork.owner()))
                    .toList();
        } catch (HttpClientErrorException exception) {
            throw new UserNotFoundException("User: " + username + " not found");
        }
    }

    public List<BranchResult> fetchAllBranches(String owner, String repo) {
        try {
            String json = gitClient.makeBranchRequest(owner, repo);
            return gitMapper.mapJsonToListBranchResult(json);
        } catch (IllegalArgumentException exception) {
            log.error(exception.getMessage());
            return Collections.emptyList();
        }
    }

    public GitAndBranchResponse fetchAllInformation(String username) {
        List<GitAndBranchResult> allResults = new ArrayList<>();
        List<GitResult> gitResults = fetchAllRepos(username);
        for (GitResult result :
                gitResults) {
            List<BranchResult> branchResult = fetchAllBranches(result.owner().login(), result.name());
            GitAndBranchResult allInformation = new GitAndBranchResult(result.name(), result.owner(), branchResult);
            allResults.add(allInformation);
        }
        return new GitAndBranchResponse(allResults);
    }
}
