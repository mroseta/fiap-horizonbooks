package com.horizonbooks.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TABELAPAIS")
public class PaisEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(name="nome_pais")
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<EditoraEntity> editoras;

    public PaisEntity() {
    }

    public PaisEntity(String nome, List<EditoraEntity> editoras) {
        this.nome = nome;
        this.editoras = editoras;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EditoraEntity> getEditoras() {
        return editoras;
    }

    public void setEditoras(List<EditoraEntity> editoras) {
        this.editoras = editoras;
    }
}
