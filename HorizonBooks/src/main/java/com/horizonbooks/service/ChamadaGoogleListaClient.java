package com.horizonbooks.service;


import com.horizonbooks.domain.lista_livro.GoogleAPIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name="ListGoogle", url="https://www.googleapis.com/books/v1")
public interface ChamadaGoogleListaClient {


    @RequestMapping(method = RequestMethod.GET,
            value="/volumes?q=",
            produces = "application/json")
    GoogleAPIResponse responseListGoogle (@RequestParam String q);

}
