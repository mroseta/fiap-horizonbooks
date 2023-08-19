package com.horizonbooks.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TABELACATEGORIA")
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name="nome_categoria")
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorias")
    private List<LivroEntity> livros;

    public CategoriaEntity() {
    }

    public CategoriaEntity(String nome, List<LivroEntity> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroEntity> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroEntity> livros) {
        this.livros = livros;
    }
}
