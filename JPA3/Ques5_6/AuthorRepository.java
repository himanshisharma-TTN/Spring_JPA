package com.springJPA2.JPA3.Ques5_6;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @EntityGraph(attributePaths = {"book"})
        // Fetches Book only when needed
    List<Author> findAll();
}
