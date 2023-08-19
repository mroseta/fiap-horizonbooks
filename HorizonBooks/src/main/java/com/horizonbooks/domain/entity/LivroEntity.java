package com.horizonbooks.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="TABELALIVRO")
public class LivroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(name="numero_isbn")
    private String isbn;

    @Column(name="titulo_livro")
    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = {@JoinColumn(name = "id_livro")},
            inverseJoinColumns = {@JoinColumn(name = "id_autor")}
    )
    private List<AutorEntity> autores;

    @ManyToOne
    @JoinColumn(name = "idEditora")
    private EditoraEntity editora;


    @ManyToMany
    @JoinTable(
            name = "LIVRO_CATEGORIA",
            joinColumns = @JoinColumn(name = "id_Livro"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<CategoriaEntity> categorias;

    @Column(name="avaliacao_media")
    private Double mediaAvaliacao;

    public LivroEntity() {
    }

    public LivroEntity(String isbn, String titulo, List<AutorEntity> autores, EditoraEntity editora, List<CategoriaEntity> categorias, Double mediaAvaliacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.categorias = categorias;
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorEntity> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorEntity> autores) {
        this.autores = autores;
    }

    public EditoraEntity getEditora() {
        return editora;
    }

    public void setEditora(EditoraEntity editora) {
        this.editora = editora;
    }

    public List<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }

    public Double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(Double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }
}
