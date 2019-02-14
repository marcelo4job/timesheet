package com.marcelo.controle.repository;

import com.marcelo.controle.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
