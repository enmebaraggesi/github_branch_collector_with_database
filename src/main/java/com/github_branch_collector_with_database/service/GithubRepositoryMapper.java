package com.github_branch_collector_with_database.service;

import com.github_branch_collector_with_database.domain.GithubRepository;
import com.github_branch_collector_with_database.received.RepositoryReceivedDto;
import com.github_branch_collector_with_database.response.RepositoryResponseDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
class GithubRepositoryMapper {
    
    public static List<GithubRepository> mapRepositoryReceivedDtoArrayToGithubRepositoryList(RepositoryReceivedDto[] array) {
        return Arrays.stream(array)
                     .map(GithubRepositoryMapper::mapRepositoryReceivedDtoToGithubRepository)
                     .toList();
    }
    
    static List<RepositoryResponseDto> mapGithubRepositoryListToRepositoryResponseDtoList(List<GithubRepository> repositories) {
        return repositories.stream()
                           .map(GithubRepositoryMapper::mapGithubRepositoryToRepositoryResponseDto)
                           .toList();
    }
    
    static List<GithubRepository> filterNotForkedRepositoriesOnly(List<GithubRepository> repositories) {
        return repositories.stream()
                           .filter(repo -> !repo.getFork())
                           .toList();
    }
    
    private static RepositoryResponseDto mapGithubRepositoryToRepositoryResponseDto(GithubRepository repository) {
        return new RepositoryResponseDto(repository.getName(),
                                         GithubOwnerMapper.mapOwnerToOwnerName(repository.getOwner()),
                                         GithubBranchMapper.mapGithubBranchListToBranchResponseDtoList(repository.getBranches()));
    }
    
    private static GithubRepository mapRepositoryReceivedDtoToGithubRepository(RepositoryReceivedDto dto) {
        return new GithubRepository(dto.name(),
                                    GithubOwnerMapper.mapOwnerReceivedDtoToOwner(dto.owner()),
                                    dto.fork(),
                                    Collections.emptyList());
    }
}
