package com.horizonbooks.repository;

import com.horizonbooks.domain.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TabelaAutorRepository extends JpaRepository<AutorEntity, Long> {
}
