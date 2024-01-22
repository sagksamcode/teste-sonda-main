package br.com.elo7.sonda.candidato.controllers;

import br.com.elo7.sonda.candidato.domains.models.vos.requests.CommandRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.requests.ProbeRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbePostResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbeResponse;
import br.com.elo7.sonda.candidato.services.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/probes")
public class ProbeController {

    @Autowired
    ProbeService service;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbeResponse> findOne(@PathVariable Long id) {

        final ProbeResponse response = service.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProbeResponse>> findAll() {
        final List<ProbeResponse> responses = service.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbePostResponse> create(@RequestBody ProbeRequest probeRequest) {
        final ProbePostResponse response = service.insert(probeRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/commands", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbePostResponse> commands(@RequestBody() CommandRequest commandRequest) {

        final ProbePostResponse response = service.processesCommands(commandRequest.getProbeId(), commandRequest.getCommands());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
