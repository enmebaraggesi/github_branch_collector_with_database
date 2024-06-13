package com.github_branch_collector_with_database.received;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CommitReceivedDto(String sha) {

}
