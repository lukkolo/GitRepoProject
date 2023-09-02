package com.example.gitrepoproject.infrastructure.controller;


import com.example.gitrepoproject.domain.proxy.dto.GitAndBranchResponse;
import com.example.gitrepoproject.domain.service.GitMapper;
import com.example.gitrepoproject.domain.service.GitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repos")
public class GitController {


    GitService gitService;

    GitMapper gitMapper;

    public GitController(GitService gitService, GitMapper gitMapper) {
        this.gitService = gitService;
        this.gitMapper = gitMapper;
    }

    @GetMapping("/{user}")
    public ResponseEntity<GitAndBranchResponse> getInfo(@PathVariable String user) {
        GitAndBranchResponse response = new GitAndBranchResponse(gitService.fetchAllInformation(user).gitAndBranchResultList());
        return ResponseEntity.ok(response);
    }


}
