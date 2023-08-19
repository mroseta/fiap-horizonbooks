package com.horizonbooks.repository;

import com.horizonbooks.domain.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TabelaPaisRepository extends JpaRepository<PaisEntity, Long> {
}
