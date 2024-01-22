package br.com.elo7.sonda.candidato.builders;

import br.com.elo7.sonda.candidato.domains.models.Coordinate;
import br.com.elo7.sonda.candidato.domains.models.Probe;

public class CoordinateBuilder {

    public Coordinate coordinate = new Coordinate();

    public CoordinateBuilder withHorizontalAxisX(int positionAxisX){

        coordinate.setHorizontalAxis(positionAxisX);
        return this;
    }

    public CoordinateBuilder withVerticalAxisY (int positionAxisY){

        coordinate.setVerticalAxis(positionAxisY);
        return this;
    }


    public Coordinate build(){
        return coordinate;
    }

}
