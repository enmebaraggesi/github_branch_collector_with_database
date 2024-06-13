package com.github_branch_collector_with_database.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GithubRepository {
    
    private String name;
    private GithubOwner owner;
    private Boolean fork;
    private List<GithubBranch> branches;
}
