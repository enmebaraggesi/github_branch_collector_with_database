package com.github_branch_collector_with_database.db.repository;

import com.github_branch_collector_with_database.db.entity.GithubRepo;
import org.springframework.data.repository.Repository;

public interface GithubRepoRepository extends Repository<GithubRepo, Long> {
    
    GithubRepo save(GithubRepo githubRepo);
//    List<GithubRepo> findAll();
//    GithubRepo findByOwner(String name);
//    GithubRepo findById(Long id);
//    boolean existsById(Long id);
//    GithubRepo updateById(Long id, GithubRepo githubRepo);
//    void deleteById(Long id);
}
