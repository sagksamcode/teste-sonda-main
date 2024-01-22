package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.Planet;

public class PlanetBuilder {

    private Planet planet = new Planet();

    public PlanetBuilder withId(final Long id){

        planet.setId(id);
        return this;
    }

    public PlanetBuilder withName(final String name){

        planet.setName(name);
        return this;
    }
    public PlanetBuilder withWidth(final int width){

        planet.setWidth(width);
        return this;
    }

    public PlanetBuilder withHeight(final int height){

        planet.setHeight(height);
        return this;
    }

    public Planet build() {
        return planet;
    }
}
