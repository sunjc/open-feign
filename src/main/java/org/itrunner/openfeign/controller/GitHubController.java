package org.itrunner.openfeign.controller;

import org.itrunner.openfeign.feign.AuthGitHubClient;
import org.itrunner.openfeign.feign.GitHubClient;
import org.itrunner.openfeign.model.Contributor;
import org.itrunner.openfeign.model.Params;
import org.itrunner.openfeign.model.Traffic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {
    private final GitHubClient gitHubClient;
    private final AuthGitHubClient authGitHubClient;

    @Autowired
    public GitHubController(GitHubClient gitHubClient, AuthGitHubClient authGitHubClient) {
        this.gitHubClient = gitHubClient;
        this.authGitHubClient = authGitHubClient;
    }

    @GetMapping("/contributors")
    public List<Contributor> contributors() {
        return gitHubClient.contributors("OpenFeign", "feign");
    }

    @GetMapping("/traffics")
    public Traffic user() {
        return authGitHubClient.traffics("sunjc", "open-feign", new Params("week"));
    }
}
