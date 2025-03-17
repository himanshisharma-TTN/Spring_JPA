package com.springJPA2.JPA2.Ques3.table_per_class;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Developer extends Person {
    private String programmingLanguage;
    private int yearsOfExperience;
}
