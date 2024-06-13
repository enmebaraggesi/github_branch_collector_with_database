package com.github_branch_collector_with_database.error;

public class XmlFormatException extends RuntimeException {
    
    public XmlFormatException(String accept) {
        super("Accept header was: " + accept);
    }
}
