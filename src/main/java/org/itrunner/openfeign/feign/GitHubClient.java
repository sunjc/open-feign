package org.itrunner.openfeign.feign;

import org.itrunner.openfeign.model.Contributor;
import org.itrunner.openfeign.model.Issue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GitHubClient {
    @GetMapping("/repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@PathVariable("owner") String owner, @PathVariable("repo") String repo);

    @PostMapping("/repos/{owner}/{repo}/issues")
    void createIssue(@RequestBody Issue issue, @PathVariable("owner") String owner, @PathVariable("repo") String repo);
}
