package com.github_branch_collector_with_database.db.repository;

import com.github_branch_collector_with_database.domain.entity.GithubRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GithubRepoRepository extends Repository<GithubRepo, Long> {
    
    GithubRepo save(GithubRepo githubRepo);
    
    @Query("SELECT r FROM GithubRepo r")
    List<GithubRepo> findAll();
    
    @Query("SELECT r FROM GithubRepo r WHERE r.owner = :owner")
    List<GithubRepo> findAllByOwner(String owner);
    
    boolean existsByOwner(String owner);
    
    @Query("SELECT r FROM GithubRepo r WHERE r.id = :id")
    GithubRepo findById(Long id);
    
    boolean existsById(Long id);
//    void deleteById(Long id);
}
