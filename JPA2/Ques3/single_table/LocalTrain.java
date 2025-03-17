package com.springJPA2.JPA2.Ques3.single_table;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("LocalTrain")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalTrain extends Train {
    @Column(nullable = false)
    private Long localId;
}
