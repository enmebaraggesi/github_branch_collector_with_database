package com.github_branch_collector_with_database.service.github_db_services;

import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import com.github_branch_collector_with_database.request.PatchGithubRepoRequestDto;
import com.github_branch_collector_with_database.response.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GithubRepoMapper {
    
    static GithubRepo mapGithubRepositoryToGithubRepo(GithubRepository repo) {
        return new GithubRepo(repo.getName(), repo.getOwner().getLogin());
    }
    
    static AllGithubRepsResponseDto mapGithubRepoListToAllGithubRepsResponseDto(List<GithubRepo> repoList) {
        List<GithubRepoSingleResponseDto> list = getGithubRepoSingleResponseDtos(repoList);
        return new AllGithubRepsResponseDto(list);
    }
    
    static GithubRepoSingleResponseDto mapGithubRepoToGithubRepoSingleResponseDto(GithubRepo repo) {
        return new GithubRepoSingleResponseDto(repo.getId(), repo.getName(), repo.getOwner());
    }
    
    static AllForOwnerGithubRepsResponseDto mapGithubRepoListToAllForOwnerGithubRepsResponseDto(List<GithubRepo> repoList) {
        List<GithubRepoSingleResponseDto> list = getGithubRepoSingleResponseDtos(repoList);
        return new AllForOwnerGithubRepsResponseDto(list);
    }
    
    static GithubRepo mapPatchGithubRepoRequestDtoToGithubRepo(PatchGithubRepoRequestDto requestDto) {
        return new GithubRepo(requestDto.name(), requestDto.owner());
    }
    
    static PatchGithubRepoResponseDto mapGithubRepoToPatchGithubRepoResponseDto(GithubRepo githubRepo) {
        return new PatchGithubRepoResponseDto("Patched repository by id: " + githubRepo.getId()
                                                      + ". Current name: " + githubRepo.getName()
                                                      + ", owner: " + githubRepo.getOwner());
    }
    
    static DeleteGithubRepoResponseDto mapIdToDeleteGithubRepoResponseDto(Long id) {
        return new DeleteGithubRepoResponseDto("Deleted song with id: " + id);
    }
    
    private static List<GithubRepoSingleResponseDto> getGithubRepoSingleResponseDtos(List<GithubRepo> repoList) {
        return repoList.stream()
                       .map(GithubRepoMapper::mapGithubRepoToGithubRepoSingleResponseDto)
                       .toList();
    }
}
