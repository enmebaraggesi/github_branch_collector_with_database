package com.github_branch_collector_with_database.service.github_db_services;

import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Transactional
@Service
class GithubRepoUpdater {
    
    private final GithubRepoRetriever retriever;
    
    GithubRepoUpdater(GithubRepoRetriever retriever) {
        this.retriever = retriever;
    }
    
    GithubRepo updateById(Long id, GithubRepo repoUpdate) {
        GithubRepo currentRepo = retriever.findById(id);
        if (repoUpdate.getName() != null) {
            currentRepo.setName(repoUpdate.getName());
            log.info("Patched repository by id: {}, with new name: {}", id, repoUpdate.getName());
        }
        if (repoUpdate.getOwner() != null) {
            currentRepo.setOwner(repoUpdate.getOwner());
            log.info("Patched repository by id: {}, with new owner: {}", id, repoUpdate.getOwner());
        }
        return currentRepo;
    }
}
