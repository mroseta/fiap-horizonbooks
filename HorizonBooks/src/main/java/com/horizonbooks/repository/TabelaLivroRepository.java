package com.horizonbooks.repository;

import com.horizonbooks.domain.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TabelaLivroRepository extends JpaRepository<LivroEntity, Long> {
}
