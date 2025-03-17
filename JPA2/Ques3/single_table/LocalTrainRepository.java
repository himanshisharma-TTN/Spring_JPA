package com.springJPA2.JPA2.Ques3.single_table;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalTrainRepository extends JpaRepository<LocalTrain, Long> {
    List<Train> findByCapacityGreaterThan(int val);
}
