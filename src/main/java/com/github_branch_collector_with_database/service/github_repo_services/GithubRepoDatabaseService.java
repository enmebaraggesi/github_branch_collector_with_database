package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.controller.AllGithubRepsResponseDto;
import com.github_branch_collector_with_database.domain.GithubRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class GithubRepoDatabaseService {
    
    private final GithubRepoAdder adder;
    private final GithubRepoRetriever retriever;
    
    public GithubRepoDatabaseService(GithubRepoAdder adder, GithubRepoRetriever retriever) {
        this.adder = adder;
        this.retriever = retriever;
    }
    
    public void saveAllToDb(List<GithubRepository> repositories) {
        log.info("Saving {} repositories", repositories.size());
        adder.saveAll(repositories);
        log.info("Done.");
    }
    
    public AllGithubRepsResponseDto findAllRepositories() {
        log.info("Finding all repositories");
        AllGithubRepsResponseDto responseDto = retriever.findAll();
        log.info("Found.");
        return responseDto;
    }
}
