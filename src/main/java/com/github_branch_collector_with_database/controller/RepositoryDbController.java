package com.github_branch_collector_with_database.controller;

import com.github_branch_collector_with_database.service.github_repo_services.GithubRepoDatabaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("db")
public class RepositoryDbController {
    
    private final GithubRepoDatabaseService service;
    
    public RepositoryDbController(GithubRepoDatabaseService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<AllGithubRepsResponseDto> getAllRepository() {
        return ResponseEntity.ok(service.findAllRepositories());
    }
}