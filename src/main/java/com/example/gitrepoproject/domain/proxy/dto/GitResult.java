package com.example.gitrepoproject.domain.proxy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GitResult(String name, Owner owner) {
}
