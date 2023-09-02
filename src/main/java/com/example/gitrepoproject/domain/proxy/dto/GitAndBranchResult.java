package com.example.gitrepoproject.domain.proxy.dto;

import java.util.List;

public record GitAndBranchResult(String name, Owner owner, List<BranchResult> branchResultList) {
}
