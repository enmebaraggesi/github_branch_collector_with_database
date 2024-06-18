package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.request.PatchGithubRepoRequestDto;
import com.github_branch_collector_with_database.response.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class GithubRepoDatabaseService {
    
    private final GithubRepoMapper mapper;
    private final GithubRepoAdder adder;
    private final GithubRepoRetriever retriever;
    private final GithubRepoUpdater updater;
    private final GithubRepoDeleter deleter;
    
    public GithubRepoDatabaseService(GithubRepoAdder adder, GithubRepoMapper mapper, GithubRepoRetriever retriever, GithubRepoUpdater updater, GithubRepoDeleter deleter) {
        this.adder = adder;
        this.mapper = mapper;
        this.retriever = retriever;
        this.updater = updater;
        this.deleter = deleter;
    }
    
    //todo bring mapping into service methods
    public void saveAllToDb(List<GithubRepository> repositories) {
        log.info("Saving {} repositories", repositories.size());
        adder.saveAll(repositories);
    }
    
    public AllGithubRepsResponseDto findAllRepositories(Pageable pageable) {
        log.info("Finding all repositories");
        return retriever.findAll(pageable);
    }
    
    public AllForOwnerGithubRepsResponseDto findAllRepositoriesForOwner(String owner) {
        log.info("Finding all repositories for owner: {}", owner);
        return retriever.findAllForOwner(owner);
    }
    
    public PatchGithubRepoResponseDto patchRepositoryById(Long id, PatchGithubRepoRequestDto requestDto) {
        log.info("Patching repository with id: {}", id);
        GithubRepo repoUpdate = mapper.mapPatchGithubRepoRequestDtoToGithubRepo(requestDto);
        GithubRepo updatedRepo = updater.updateById(id, repoUpdate);
        return mapper.mapGithubRepoToPatchGithubRepoResponseDto(updatedRepo);
    }
    
    public DeleteGithubRepoResponseDto deleteById(Long id) {
        log.info("Deleting repository with id: {}", id);
        deleter.deleteById(id);
        return mapper.mapIdToDeleteGithubRepoResponseDto(id);
    }
}
