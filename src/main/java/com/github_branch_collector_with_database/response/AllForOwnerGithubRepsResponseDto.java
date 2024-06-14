package com.github_branch_collector_with_database.response;

import java.util.List;

public record AllForOwnerGithubRepsResponseDto(List<GithubRepoSingleResponseDto> repositories) {

}
