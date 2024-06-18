package com.github_branch_collector_with_database.service.github_db_services;

import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.error.IdNotFoundException;
import com.github_branch_collector_with_database.error.OwnerNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GithubRepoRetriever {
    
    private final GithubRepoRepository repository;
    
    GithubRepoRetriever(GithubRepoRepository repository) {
        this.repository = repository;
    }
    
    public List<GithubRepo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    public List<GithubRepo> findAllForOwner(String owner) {
        existsByOwner(owner);
        return repository.findAllByOwner(owner);
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
