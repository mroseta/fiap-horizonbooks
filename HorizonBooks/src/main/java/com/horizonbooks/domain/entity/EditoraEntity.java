package com.horizonbooks.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TABELAEDITORA")
public class EditoraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditora;

    @Column(name="nome_editora")
    private String nome;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<LivroEntity> livros;

    @ManyToOne
    private PaisEntity pais;

    public EditoraEntity() {
    }

    public EditoraEntity(String nome, List<LivroEntity> livros, PaisEntity pais) {
        this.nome = nome;
        this.livros = livros;
        this.pais = pais;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
}
