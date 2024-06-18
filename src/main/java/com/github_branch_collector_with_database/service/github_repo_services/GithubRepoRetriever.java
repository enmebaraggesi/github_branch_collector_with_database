package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.error.IdNotFoundException;
import com.github_branch_collector_with_database.error.OwnerNotFoundException;
import com.github_branch_collector_with_database.response.AllForOwnerGithubRepsResponseDto;
import com.github_branch_collector_with_database.response.AllGithubRepsResponseDto;
import org.springframework.data.domain.Pageable;
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
    
    public AllGithubRepsResponseDto findAll(Pageable pageable) {
        List<GithubRepo> githubRepoList = repository.findAll(pageable);
        return mapper.mapGithubRepoListToAllGithubRepsResponseDto(githubRepoList);
    }
    
    public AllForOwnerGithubRepsResponseDto findAllForOwner(String owner) {
        existsByOwner(owner);
        List<GithubRepo> githubRepoList = repository.findAllByOwner(owner);
        return mapper.mapGithubRepoListToAllForOwnerGithubRepsResponseDto(githubRepoList);
    }
    
    public GithubRepo findById(Long id) {
        existsById(id);
        return repository.findById(id);
    }
    
    public void existsById(Long id) {
        if (!repository.existsById(id)) {
            throw new IdNotFoundException();
        }
    }
    
    private void existsByOwner(String owner) {
        if (!repository.existsByOwner(owner)) {
            throw new OwnerNotFoundException();
        }
    }
}
