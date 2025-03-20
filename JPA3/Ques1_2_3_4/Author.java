package com.springJPA2.JPA3.Ques1_2_3_4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @ElementCollection
    @CollectionTable(name = "author_subjects", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "subject", nullable = false)
    List<String> subjects;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "Author{" +
                "subjects=" + subjects +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

