package com.github_branch_collector_with_database.service.github_repo_services;

import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.response.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GithubRepoMapper {
    
    static GithubRepo mapGithubRepositoryToGithubRepo(GithubRepository repo) {
        return new GithubRepo(repo.getName(), repo.getOwner().getLogin());
    }
    
    public AllGithubRepsResponseDto mapGithubRepoListToAllGithubRepsResponseDto(List<GithubRepo> repoList) {
        List<GithubRepoSingleResponseDto> singleResponseDtoList = repoList.stream()
                                                                          .map(this::mapGithubRepoToGithubRepoSingleResponseDto)
                                                                          .toList();
        return new AllGithubRepsResponseDto(singleResponseDtoList);
    }
    
    public GithubRepoSingleResponseDto mapGithubRepoToGithubRepoSingleResponseDto(GithubRepo repo) {
        return new GithubRepoSingleResponseDto(repo.getId(), repo.getName(), repo.getOwner());
    }
    
    public AllForOwnerGithubRepsResponseDto mapGithubRepoListToAllForOwnerGithubRepsResponseDto(List<GithubRepo> repoList) {
        List<GithubRepoSingleResponseDto> singleResponseDtoList = repoList.stream()
                                                                          .map(this::mapGithubRepoToGithubRepoSingleResponseDto)
                                                                          .toList();
        return new AllForOwnerGithubRepsResponseDto(singleResponseDtoList);
    }
}
