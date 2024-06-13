package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.db.entity.GithubRepo;
import com.github_branch_collector_with_database.domain.GithubRepository;
import org.springframework.stereotype.Component;

@Component
public class GithubRepoMapper {
    
    static GithubRepo mapGithubRepositoryToGithubRepo(GithubRepository repo) {
        return new GithubRepo(repo.getName(), repo.getOwner().getLogin());
    }
}
