package com.springJPA2.JPA3.Ques1_2_3_4;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(nullable = false)
    private String streetNumber;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String State;
}
