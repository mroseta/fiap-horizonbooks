package com.horizonbooks.service;

import com.horizonbooks.domain.detalhe.GoogleAPIDetailResponse;
import com.horizonbooks.domain.entity.*;
import com.horizonbooks.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadaAzure {

    TabelaLivroRepository tabelaLivroRepository;
    TabelaAutorRepository tabelaAutorRepository;
    TabelaPaisRepository tabelaPaisRepository;
    TabelaCategoriaRespository tabelaCategoriaRespository;
    TabelaEditoraRepository tabelaEditoraRepository;

    public void salvaBDHorizonBooks(GoogleAPIDetailResponse googleAPIDetailResponse) {


        CategoriaEntity mainCategoryEntity = new CategoriaEntity();
        mainCategoryEntity.setNome(googleAPIDetailResponse.getVolumeInfo().getMainCategory());

        List<CategoriaEntity> categoriasPersistidas = new ArrayList<>();
        for (String categoriaNome : googleAPIDetailResponse.getVolumeInfo().getCategories()) {
            CategoriaEntity categoria = createCategoria(categoriaNome);
            categoriasPersistidas.add(categoria);
        }

        List<CategoriaEntity> todasCategorias = new ArrayList<>();
        todasCategorias.add(mainCategoryEntity);
        todasCategorias.addAll(categoriasPersistidas);

        PaisEntity paisEntity = mapperPais(googleAPIDetailResponse);
        tabelaPaisRepository.save(paisEntity);


        EditoraEntity editoraEntity = mapperEditora(googleAPIDetailResponse, paisEntity);
        tabelaEditoraRepository.save(editoraEntity);


        LivroEntity livroEntity = mapperLivro(googleAPIDetailResponse, editoraEntity, todasCategorias);
        tabelaLivroRepository.save(livroEntity);


    }

    private CategoriaEntity createCategoria(String categoriaNome) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNome(categoriaNome);
        tabelaCategoriaRespository.save(categoria);
        return categoria;
    }

    private LivroEntity mapperLivro(GoogleAPIDetailResponse googleAPIDetailResponse, EditoraEntity editoraEntity, List<CategoriaEntity> todasCategorias) {

        LivroEntity l = new LivroEntity();
        l.setIsbn(String.valueOf(googleAPIDetailResponse.getVolumeInfo().getIndustryIdentifiers().stream()
                .filter(industryIdentifier -> "ISBN_13".equals(industryIdentifier.getType()))
                .findFirst()
                .orElse(null)));

        l.setTitulo(googleAPIDetailResponse.getVolumeInfo().getTitle());

        List<String> autores = googleAPIDetailResponse.getVolumeInfo().getAuthors();
        List<AutorEntity> autorEntities = new ArrayList<>();
        for (String autorNome : autores) {
            AutorEntity autorEntity = new AutorEntity();
            autorEntity.setNome(autorNome);
            autorEntities.add(autorEntity);
        }
        l.setAutores(autorEntities);

        l.setEditora(editoraEntity);
        l.setCategorias(todasCategorias);
        l.setMediaAvaliacao(googleAPIDetailResponse.getVolumeInfo().getAverageRating());

        return l;
    }

    private EditoraEntity mapperEditora(GoogleAPIDetailResponse googleAPIDetailResponse, PaisEntity paisEntity) {

        EditoraEntity e = new EditoraEntity();
        e.setNome(googleAPIDetailResponse.getVolumeInfo().getPublisher());
        e.setPais(paisEntity);

        return e;
    }

    private PaisEntity mapperPais(GoogleAPIDetailResponse googleAPIDetailResponse) {

        PaisEntity p = new PaisEntity();
        p.setNome(googleAPIDetailResponse.getAccessInfo().getCountry());

        return p;
    }

}
