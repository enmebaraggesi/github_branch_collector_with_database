package com.github_branch_collector_with_database.response.error;

import org.springframework.http.HttpStatus;

public record UserNotFoundExceptionResponseDto(HttpStatus status, String message) {

}
