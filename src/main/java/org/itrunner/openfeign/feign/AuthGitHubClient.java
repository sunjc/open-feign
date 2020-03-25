package org.itrunner.openfeign.feign;

import org.itrunner.openfeign.config.GitHubConfiguration;
import org.itrunner.openfeign.model.Params;
import org.itrunner.openfeign.model.Traffic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "auth", name = "github", configuration = GitHubConfiguration.class)
public interface AuthGitHubClient {
    @GetMapping("/repos/{owner}/{repo}/traffic/views")
    Traffic traffics(@PathVariable("owner") String owner, @PathVariable("repo") String repo, @SpringQueryMap Params params);
}
