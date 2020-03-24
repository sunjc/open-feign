package org.itrunner.openfeign.controller;

import org.itrunner.openfeign.feign.GitHubClient;
import org.itrunner.openfeign.model.Contributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {
    private final GitHubClient gitHubClient;

    @Autowired
    public GitHubController(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @GetMapping("/contributors")
    public List<Contributor> contributors() {
        return gitHubClient.contributors("OpenFeign", "feign");
    }
}
