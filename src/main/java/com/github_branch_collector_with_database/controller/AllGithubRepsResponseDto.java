package com.github_branch_collector_with_database.controller;

import java.util.List;

public record AllGithubRepsResponseDto(List<GithubRepoSingleResponseDto> repositories) {

}
