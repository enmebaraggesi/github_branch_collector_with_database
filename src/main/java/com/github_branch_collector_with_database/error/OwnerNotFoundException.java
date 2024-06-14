package com.github_branch_collector_with_database.error;

public class OwnerNotFoundException extends RuntimeException {
    
    public OwnerNotFoundException() {
        super("Owner not found");
    }
}
