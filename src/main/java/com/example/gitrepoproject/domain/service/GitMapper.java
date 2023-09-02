package com.example.gitrepoproject.domain.service;

import com.example.gitrepoproject.domain.proxy.dto.BranchResult;
import com.example.gitrepoproject.domain.proxy.dto.GitResultWithFork;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class GitMapper {

    private final ObjectMapper objectMapper;


    public GitMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    List<GitResultWithFork> mapJsonToGitResponse(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException exception) {
            log.error(exception.getMessage());
            return Collections.emptyList();
        }
    }

    List<BranchResult> mapJsonToListBranchResult(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException exception) {
            log.error(exception.getMessage());
            return Collections.emptyList();
        }
    }


}
