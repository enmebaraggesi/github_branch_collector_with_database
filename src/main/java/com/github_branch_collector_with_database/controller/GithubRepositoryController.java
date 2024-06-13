package com.github_branch_collector_with_database.controller;

import com.github_branch_collector_with_database.response.RepositoryResponseDto;
import com.github_branch_collector_with_database.service.GithubRepositoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class GithubRepositoryController {
    
    private final GithubRepositoryService githubRepositoryService;
    
    public GithubRepositoryController(GithubRepositoryService githubRepositoryService) {
        this.githubRepositoryService = githubRepositoryService;
    }
    
    @GetMapping("/repos/{username}")
    public List<RepositoryResponseDto> getAllNotForkedReposForUser(@PathVariable String username,
                                                                   @RequestHeader String accept) {
        return githubRepositoryService.getAllNotForkedReposForUser(username, accept);
    }
}
