package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.vos.responses.PlanetPostResponse;

public class PlanetPostResponseBuilder {

    private PlanetPostResponse planetPostResponse = new PlanetPostResponse();

    public PlanetPostResponseBuilder withId(final Long id){

        planetPostResponse.setId(id);
        return this;
    }
    public PlanetPostResponse build(){
        return planetPostResponse;
    }
}
