package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.Coordinate;
import br.com.elo7.sonda.candidato.domains.models.Direction;
import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbePostResponse;

public class ProbePostResponseBuilder {

    private ProbePostResponse probePostResponse = new ProbePostResponse();

    public ProbePostResponseBuilder withId(final Long id){

        probePostResponse.setId(id);
        return this;
    }

    public ProbePostResponseBuilder withPlanet(final Planet planet){

        probePostResponse.setPlanet(planet);
        return this;
    }

    public ProbePostResponseBuilder withCoordinate(final Coordinate coordinate){

        probePostResponse.setCoordinate(coordinate);
        return this;
    }

    public ProbePostResponseBuilder withDirection(final Direction direction){

        probePostResponse.setDirection(direction);
        return this;
    }
    public ProbePostResponse build(){
        return probePostResponse;
    }
}
