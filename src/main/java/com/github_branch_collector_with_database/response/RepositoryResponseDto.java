package com.github_branch_collector_with_database.response;

import java.util.List;

public record RepositoryResponseDto(String repoName,
                                    String ownerName,
                                    List<BranchResponseDto> branches
) {

}
