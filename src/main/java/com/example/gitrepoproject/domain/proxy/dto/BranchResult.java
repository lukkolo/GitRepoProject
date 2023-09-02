package com.example.gitrepoproject.domain.proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BranchResult(String name, Commit commit) {
}
