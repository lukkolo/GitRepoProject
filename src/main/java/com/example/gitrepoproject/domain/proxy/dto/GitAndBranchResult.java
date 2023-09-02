package com.example.gitrepoproject.domain.proxy;

import java.util.List;

public record GitAndBranchResult(String name, Owner owner, List<BranchResult> branchResultList) {
}
