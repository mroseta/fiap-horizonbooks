package com.horizonbooks.service;


import com.horizonbooks.domain.detalhe.GoogleAPIDetailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name="DetailGoogle", url="https://www.googleapis.com/books/v1")
public interface ChamadaDetalheLivroClient {

    @RequestMapping(method = RequestMethod.GET,
            value="/volumes/{volumeId}",
            produces = "application/json")
    GoogleAPIDetailResponse responseDetailGoogle(@PathVariable("volumeId") String id);
}
