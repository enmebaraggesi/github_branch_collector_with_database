package com.github_branch_collector_with_database.service.github_db_services;

import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import org.springframework.stereotype.Service;

@Service
class GithubRepoDeleter {
    
    private final GithubRepoRepository repository;
    private final GithubRepoRetriever retriever;
    
    GithubRepoDeleter(GithubRepoRepository repository, GithubRepoRetriever retriever) {
        this.repository = repository;
        this.retriever = retriever;
    }
    
    void deleteById(Long id) {
        retriever.existsById(id);
        repository.deleteById(id);
    }
}
