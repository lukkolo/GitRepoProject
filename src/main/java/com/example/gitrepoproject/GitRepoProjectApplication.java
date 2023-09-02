package com.example.gitrepoproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class GitRepoProjectApplication {


    @Autowired
    MainAppRunner mainAppRunner;

    public static void main(String[] args) {
        SpringApplication.run(GitRepoProjectApplication.class, args);
    }


    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        mainAppRunner.start();
    }
}


