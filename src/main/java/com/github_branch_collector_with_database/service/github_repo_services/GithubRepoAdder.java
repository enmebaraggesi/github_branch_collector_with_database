package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.db.repository.GithubRepoRepository;
import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class GithubRepoAdder {
    
    private final GithubRepoRepository repository;
    
    public GithubRepoAdder(GithubRepoRepository repository) {
        this.repository = repository;
    }
    
    public void save(GithubRepo repo) {
        GithubRepo saved = repository.save(repo);
        log.info("Saved {} for {} under id {}", saved.getName(), saved.getOwner(), saved.getId());
    }
    
    public void saveAll(List<GithubRepository> repos) {
        repos.forEach(
                repo -> {
                    GithubRepo githubRepo = GithubRepoMapper.mapGithubRepositoryToGithubRepo(repo);
                    save(githubRepo);
                }
        );
    }
}
