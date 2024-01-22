package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.Coordinate;
import br.com.elo7.sonda.candidato.domains.models.Direction;
import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.Probe;

import java.security.DigestException;

public class ProbeBuilder {

    Probe probe = new Probe();

    public ProbeBuilder withId(final Long id){

        probe.setId(id);
        return this;
    }

    public ProbeBuilder withPlanet(final Planet planet){

        probe.setPlanet(planet);
        return this;
    }

    public ProbeBuilder withCoordinate(final Coordinate coordinate){

        probe.setCoordinate(coordinate);
        return this;
    }

    public ProbeBuilder withDirection(final Direction direction){

        probe.setDirection(direction);
        return this;
    }

    public Probe build(){
        return probe;
    }
}
