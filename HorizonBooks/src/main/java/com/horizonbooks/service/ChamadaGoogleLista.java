package com.horizonbooks.service;

import com.horizonbooks.domain.detalhe.GoogleAPIDetailResponse;
import com.horizonbooks.domain.lista_livro.GoogleAPIResponse;
import com.horizonbooks.domain.lista_livro.Item;
import com.horizonbooks.repository.TabelaLivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

@Service
public class ChamadaGoogleLista {

    @Autowired
    ChamadaGoogleListaClient chamadaGoogleListaClient;
    @Autowired
    ChamadaDetalheLivroClient chamadaDetalheLivroClient;
    @Autowired
    ChamadaAzure chamadaAzure;

    public void executar(String filtro) {

        GoogleAPIResponse googleAPIResponse = consultaListaBaseadoEmFiltro(filtro);

        List<Item> items = googleAPIResponse.getItems();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Stream<Object> responseDetail = forkJoinPool.submit(() ->
                items.parallelStream()
                        .map(item -> consultaDetalheGoogle(item.getId()))
                ).join();

        responseDetail.forEach(item -> {

            System.out.println("ID consultado com sucesso");
        });

        System.out.println("teste");

    }

    private Object consultaDetalheGoogle(String id) {

       GoogleAPIDetailResponse response = chamadaDetalheLivroClient.responseDetailGoogle(id);
       chamadaAzure.salvaBDHorizonBooks(response);
         return response;

    }

    private GoogleAPIResponse consultaListaBaseadoEmFiltro(String filtro) {

        GoogleAPIResponse r = chamadaGoogleListaClient.responseListGoogle(filtro);
        return r;

    }
}
