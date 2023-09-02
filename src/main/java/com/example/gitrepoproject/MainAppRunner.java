package com.example.gitrepoproject;

import com.example.gitrepoproject.domain.service.GitService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class MainAppRunner {

    GitService gitService;

    public MainAppRunner(GitService gitService) {
        this.gitService = gitService;
    }

    public void start() {

    }
}
