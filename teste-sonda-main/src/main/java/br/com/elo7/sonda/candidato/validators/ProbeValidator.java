package br.com.elo7.sonda.candidato.validators;

import br.com.elo7.sonda.candidato.domains.models.Planet;
import br.com.elo7.sonda.candidato.domains.models.vos.requests.ProbeRequest;
import br.com.elo7.sonda.candidato.exceptions.BadRequestException;

public class ProbeValidator {

    private ProbeValidator(){}

    public static void validatePosition(final ProbeRequest probeRequest, final Planet planet){

        if(probeRequest.getPositionX() > planet.getWidth())
            throw BadRequestException.invalidPositionX();
        if(probeRequest.getPositionY() > planet.getHeight())
            throw BadRequestException.invalidPositionY();
    }
}
