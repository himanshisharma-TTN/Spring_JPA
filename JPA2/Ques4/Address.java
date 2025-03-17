package com.springJPA2.JPA2.Ques4;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String pincode;
    @Column(nullable = false)
    private String streetNo;
}
