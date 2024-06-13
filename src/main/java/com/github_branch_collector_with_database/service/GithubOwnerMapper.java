package com.github_branch_collector_with_database.service;

import com.github_branch_collector_with_database.domain.GithubOwner;
import com.github_branch_collector_with_database.received.OwnerReceivedDto;
import org.springframework.stereotype.Component;

@Component
class GithubOwnerMapper {
    
    static GithubOwner mapOwnerReceivedDtoToOwner(OwnerReceivedDto dto) {
        return new GithubOwner(dto.login());
    }
    
    static String mapOwnerToOwnerName(GithubOwner owner) {
        return owner.getLogin();
    }
}
