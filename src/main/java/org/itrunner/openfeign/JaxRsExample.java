package org.itrunner.openfeign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs2.JAXRS2Contract;
import org.itrunner.openfeign.model.Contributor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public class JaxRsExample {
    interface GitHub {
        @GET
        @Path("/repos/{owner}/{repo}/contributors")
        List<Contributor> contributors(@PathParam("owner") String owner, @PathParam("repo") String repo);
    }

    public static void main(String[] args) {
        GitHub github = Feign.builder()
                .contract(new JAXRS2Contract())
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
        }
    }
}