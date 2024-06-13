package com.github_branch_collector_with_database.service;

import com.github_branch_collector_with_database.domain.GithubCommit;
import com.github_branch_collector_with_database.received.CommitReceivedDto;
import org.springframework.stereotype.Component;

@Component
class GithubCommitMapper {
    
    static GithubCommit mapCommitReceivedDtoToGithubCommit(CommitReceivedDto commit) {
        return new GithubCommit(commit.sha());
    }
    
    static String mapGithubCommitToSha(GithubCommit commit) {
        return commit.getSha();
    }
}
