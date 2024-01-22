package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.Coordinate;
import br.com.elo7.sonda.candidato.domains.models.Direction;
import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.Probe;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbeResponse;

public class ProbeResponseBuilder {

    ProbeResponse probeResponse = new ProbeResponse();

    public ProbeResponseBuilder withId(final Long id){

        probeResponse.setId(id);
        return this;
    }

    public ProbeResponseBuilder withPlanet(final Planet planet){

        probeResponse.setPlanet(planet);
        return this;
    }

    public ProbeResponseBuilder withCoordinate(final Coordinate coordinate){

        probeResponse.setCoordinate(coordinate);
        return this;
    }

    public ProbeResponseBuilder withDirection(final Direction direction){

        probeResponse.setDirection(direction);
        return this;
    }

    public ProbeResponse build(){
        return probeResponse;
    }
}
