package br.com.elo7.sonda.candidato.services;

import br.com.elo7.sonda.candidato.builders.ProbePostResponseBuilder;
import br.com.elo7.sonda.candidato.builders.CoordinateBuilder;
import br.com.elo7.sonda.candidato.builders.ProbeBuilder;
import br.com.elo7.sonda.candidato.builders.ProbeResponseBuilder;
import br.com.elo7.sonda.candidato.domains.models.Command;
import br.com.elo7.sonda.candidato.domains.models.Direction;
import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.Probe;
import br.com.elo7.sonda.candidato.domains.models.vos.requests.ProbeRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbePostResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbeResponse;
import br.com.elo7.sonda.candidato.exceptions.BadRequestException;
import br.com.elo7.sonda.candidato.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.repositories.PlanetRepository;
import br.com.elo7.sonda.candidato.repositories.ProbeRepository;
import br.com.elo7.sonda.candidato.validators.ProbeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ProbeService {

    @Autowired
    ProbeRepository probeRepository;

    @Autowired
    PlanetRepository planetRepository;

    public ProbePostResponse insert(final ProbeRequest probeRequest){

        probeRepository.findById(probeRequest.getId())
                .ifPresent(planet -> { throw BadRequestException.probeExist();});
        final Planet planet = planetRepository.findById(probeRequest.getPlanetId()).orElseThrow(() -> NotFoundException.planetNotFound());
        ProbeValidator.validatePosition(probeRequest, planet);
        final Long probeId = probeRequest.getId();
        final Probe probe = new ProbeBuilder().withId(probeId)
                .withPlanet(planet)
                .withDirection(Direction.valueOf(probeRequest.getDirection()))
                .withCoordinate(new CoordinateBuilder().withHorizontalAxisX(probeRequest.getPositionX())
                .withVerticalAxisY(probeRequest.getPositionY())
                .build())
                .build();
        probeRepository.save(probe);
        return new ProbePostResponseBuilder().withId(probeId)
                .build();
    }

    public ProbePostResponse processesCommands(Long probeId, List<Command> commands) {
        Probe probe = probeRepository.findById(probeId).orElseThrow(()-> NotFoundException.probeNotFound());
        commands.stream().forEach(command -> {
            command.run(probe);
        });
        probeRepository.save(probe);
        return new ProbePostResponseBuilder().withId(probeId)
                .withCoordinate(probe.getCoordinate())
                .withPlanet(probe.getPlanet())
                .withDirection(probe.getDirection())
                .build();
    }

    public ProbeResponse getById(Long probeId){

        final Probe probe = probeRepository.findById(probeId).orElseThrow(() -> NotFoundException.planetNotFound());
        return buildProbeResponse(probe);
    }

    public List<ProbeResponse> findAll(){

        final Iterable<Probe> probes =  probeRepository.findAll();
        if(Objects.isNull(probes))
            throw NotFoundException.planetsNotFound();

        List<ProbeResponse> probeResponses = StreamSupport.stream(probes.spliterator(), false)
                .map(this::buildProbeResponse)
                .collect(Collectors.toList());
        return probeResponses;
    }

    private ProbeResponse buildProbeResponse(final Probe probe){

        return new ProbeResponseBuilder()
                .withId(probe.getId())
                .withPlanet(probe.getPlanet())
                .withCoordinate(probe.getCoordinate())
                .withCoordinate(probe.getCoordinate())
                .build();
    }

}
