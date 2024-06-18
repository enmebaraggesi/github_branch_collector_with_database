package com.github_branch_collector_with_database.service.github_db_services;

import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.request.PatchGithubRepoRequestDto;
import com.github_branch_collector_with_database.response.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github_branch_collector_with_database.service.github_db_services.GithubRepoMapper.*;

@Log4j2
@Service
public class GithubRepoDatabaseService {
    
    private final GithubRepoAdder adder;
    private final GithubRepoRetriever retriever;
    private final GithubRepoUpdater updater;
    private final GithubRepoDeleter deleter;
    
    GithubRepoDatabaseService(GithubRepoAdder adder, GithubRepoRetriever retriever, GithubRepoUpdater updater, GithubRepoDeleter deleter) {
        this.adder = adder;
        this.retriever = retriever;
        this.updater = updater;
        this.deleter = deleter;
    }
    
    public void saveAllToDb(List<GithubRepository> repositories) {
        log.info("Saving {} repositories", repositories.size());
        adder.saveAll(repositories);
    }
    
    public AllGithubRepsResponseDto findAllRepositories(Pageable pageable) {
        log.info("Finding all repositories");
        List<GithubRepo> allRepos = retriever.findAll(pageable);
        return mapGithubRepoListToAllGithubRepsResponseDto(allRepos);
    }
    
    public AllForOwnerGithubRepsResponseDto findAllRepositoriesForOwner(String owner) {
        log.info("Finding all repositories for owner: {}", owner);
        List<GithubRepo> allForOwner = retriever.findAllForOwner(owner);
        return mapGithubRepoListToAllForOwnerGithubRepsResponseDto(allForOwner);
    }
    
    public PatchGithubRepoResponseDto patchRepositoryById(Long id, PatchGithubRepoRequestDto requestDto) {
        log.info("Patching repository with id: {}", id);
        GithubRepo repoUpdate = mapPatchGithubRepoRequestDtoToGithubRepo(requestDto);
        GithubRepo updatedRepo = updater.updateById(id, repoUpdate);
        return mapGithubRepoToPatchGithubRepoResponseDto(updatedRepo);
    }
    
    public DeleteGithubRepoResponseDto deleteById(Long id) {
        log.info("Deleting repository with id: {}", id);
        deleter.deleteById(id);
        return mapIdToDeleteGithubRepoResponseDto(id);
    }
}
