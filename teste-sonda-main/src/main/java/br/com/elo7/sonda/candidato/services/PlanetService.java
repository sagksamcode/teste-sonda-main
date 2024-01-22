package br.com.elo7.sonda.candidato.services;

import br.com.elo7.sonda.candidato.builders.PlanetBuilder;
import br.com.elo7.sonda.candidato.builders.PlanetPostResponseBuilder;
import br.com.elo7.sonda.candidato.builders.PlanetResponseBuilder;
import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.vos.requests.PlanetRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetPostResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetResponse;
import br.com.elo7.sonda.candidato.exceptions.BadRequestException;
import br.com.elo7.sonda.candidato.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository repository;

    public PlanetPostResponse insert(PlanetRequest planetRequest){

        repository.findById(planetRequest.getId())
                .ifPresent(planet -> { throw BadRequestException.planetExist();});
        final Long planetId = planetRequest.getId();
        final Planet planet = new PlanetBuilder()
                        .withId(planetId)
                        .withName(planetRequest.getName())
                        .withWidth(planetRequest.getWidth())
                        .withHeight(planetRequest.getHeight())
                        .build();
        repository.save(planet);
        return new PlanetPostResponseBuilder().withId(planetId).build();
    }

    public PlanetResponse getById(final Long id){

        final Planet planet = repository.findById(id).orElseThrow(() -> NotFoundException.planetNotFound());
        return buildPlanetResponse(planet);
    }

    public List<PlanetResponse> findAll(){

        final Iterable<Planet> planets =  repository.findAll();
        if(Objects.isNull(planets))
            throw NotFoundException.planetsNotFound();

        List<PlanetResponse> planetResponses = StreamSupport.stream(planets.spliterator(), false)
                .map(this::buildPlanetResponse)
                .collect(Collectors.toList());
        return planetResponses;
    }

    public PlanetPostResponse update(final Long id, final PlanetRequest planetRequest){

        repository.findById(id).orElseThrow(() -> NotFoundException.planetNotFound());
        final Planet planet = new PlanetBuilder()
                .withId(id)
                .withName(planetRequest.getName())
                .withWidth(planetRequest.getWidth())
                .withHeight(planetRequest.getHeight())
                .build();

        repository.save(planet);
        return new PlanetPostResponseBuilder().withId(id).build();
    }

    private PlanetResponse buildPlanetResponse(final Planet planet){
        return new PlanetResponseBuilder()
                .withId(planet.getId())
                .withName(planet.getName())
                .withHeight(planet.getHeight())
                .withWidth(planet.getWidth())
                .build();
    }

}
