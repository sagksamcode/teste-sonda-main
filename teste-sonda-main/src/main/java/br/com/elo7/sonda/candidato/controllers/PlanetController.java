package br.com.elo7.sonda.candidato.controllers;

import br.com.elo7.sonda.candidato.domains.models.vos.requests.PlanetRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetPostResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetResponse;
import br.com.elo7.sonda.candidato.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    PlanetService service;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponse> findOne(@PathVariable Long id) {

        final PlanetResponse response = service.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlanetResponse>> findAll() {
        final List<PlanetResponse> responses = service.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetPostResponse> add(@RequestBody @Valid PlanetRequest planetRequest) {

        final PlanetPostResponse response = service.insert(planetRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetPostResponse> update(@PathVariable("id") final Long id, @RequestBody PlanetRequest planetRequest) {

        final PlanetPostResponse response = service.update(id, planetRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
