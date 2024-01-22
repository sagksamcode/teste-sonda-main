package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetResponse;

public class PlanetResponseBuilder {

    public PlanetResponse planetResponse = new PlanetResponse();

    public PlanetResponseBuilder withId(final Long id){

        planetResponse.setId(id);
        return this;
    }

    public PlanetResponseBuilder withName(final String name){

        planetResponse.setName(name);
        return this;
    }
    public PlanetResponseBuilder withWidth(final int width){

        planetResponse.setWidth(width);
        return this;
    }

    public PlanetResponseBuilder withHeight(final int height){

        planetResponse.setHeight(height);
        return this;
    }

    public PlanetResponse build(){
        return planetResponse;
    }
}
