package com.horizonbooks.repository;

import com.horizonbooks.domain.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TabelaCategoriaRespository extends JpaRepository<CategoriaEntity, Long> {
}
