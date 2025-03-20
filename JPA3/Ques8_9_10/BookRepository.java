package com.springJPA2.JPA3.Ques8_9_10;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByNameAndTitle(String bookName, String bookTitle);
}
