package com.springJPA2.JPA2.Ques3.table_per_class;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Designer, Long> {
}
