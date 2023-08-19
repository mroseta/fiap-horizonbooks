package com.horizonbooks.domain.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TABELAAUTOR")
public class AutorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(name="nome_livro")
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autores")
    private List<LivroEntity> livros;

    public AutorEntity() {
    }

    public AutorEntity(String nome, List<LivroEntity> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
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
