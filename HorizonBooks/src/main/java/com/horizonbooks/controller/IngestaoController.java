package com.horizonbooks.controller;


import com.horizonbooks.service.ChamadaGoogleLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class IngestaoController {

    @Autowired
    ChamadaGoogleLista chamadaGoogleLista;

    @GetMapping("/ingestao")
    public ResponseEntity<?> solicitaIngestaoPorParametro(
            @RequestParam(value="q", required = true) String filtro
    ){

        try{
            chamadaGoogleLista.executar(filtro);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
