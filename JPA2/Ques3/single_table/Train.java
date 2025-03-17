package com.springJPA2.JPA2.Ques3.single_table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "train_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Train {
    @Id
    private int trainNumber;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "category")
    private String category;
    
}
