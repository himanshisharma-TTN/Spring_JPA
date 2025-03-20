package com.springJPA2.JPA3.Ques5_6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", unique = true, nullable = false)
    private Author author;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate publishDate;
    @Column(nullable = false)
    private String genre;

}
