package com.github_branch_collector_with_database.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GithubBranch {
    
    private String name;
    private GithubCommit commit;
}
