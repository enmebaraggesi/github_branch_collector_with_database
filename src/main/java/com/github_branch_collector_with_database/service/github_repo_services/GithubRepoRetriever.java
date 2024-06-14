package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.controller.AllGithubRepsResponseDto;
import com.github_branch_collector_with_database.db.entity.GithubRepo;
import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubRepoRetriever {
    
    private final GithubRepoRepository repository;
    private final GithubRepoMapper mapper;
    
    public GithubRepoRetriever(GithubRepoMapper mapper, GithubRepoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
    
    public AllGithubRepsResponseDto findAll() {
        List<GithubRepo> githubRepoList = repository.findAll();
        return mapper.mapGithubRepoListToAllGithubRepsResponseDto(githubRepoList);
    }
}
