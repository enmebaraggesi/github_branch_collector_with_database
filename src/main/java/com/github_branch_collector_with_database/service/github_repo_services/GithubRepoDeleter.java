package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import org.springframework.stereotype.Service;

@Service
public class GithubRepoDeleter {
    
    private final GithubRepoRepository repository;
    private final GithubRepoRetriever retriever;
    
    public GithubRepoDeleter(GithubRepoRepository repository, GithubRepoRetriever retriever) {
        this.repository = repository;
        this.retriever = retriever;
    }
    
    public void deleteById(Long id) {
        retriever.existsById(id);
        repository.deleteById(id);
    }
}
