package com.springJPA2.JPA3.Ques8_9_10;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate publishDate;
    @Column(nullable = false)
    private String genre;

    public List<Author> getAuthors() {
        if (authors == null) authors = new ArrayList<>();
        return authors;
    }

}
