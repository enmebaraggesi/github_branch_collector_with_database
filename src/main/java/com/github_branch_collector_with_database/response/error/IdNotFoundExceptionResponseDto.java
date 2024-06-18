package com.github_branch_collector_with_database.response.error;

import org.springframework.http.HttpStatus;

public record IdNotFoundExceptionResponseDto(HttpStatus status, String message) {

}
