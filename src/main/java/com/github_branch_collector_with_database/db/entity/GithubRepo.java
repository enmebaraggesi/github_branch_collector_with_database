package com.github_branch_collector_with_database.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REPO")
public class GithubRepo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "owner", nullable = false)
    private String owner;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    public GithubRepo(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }
}
