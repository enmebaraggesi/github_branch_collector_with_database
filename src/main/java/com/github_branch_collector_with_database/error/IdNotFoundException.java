package com.github_branch_collector_with_database.error;

public class IdNotFoundException extends RuntimeException {
    
    public IdNotFoundException() {
        super("Id not found");
    }
}
