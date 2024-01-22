package br.com.elo7.sonda.candidato.domains.models.vos.responses;

import br.com.elo7.sonda.candidato.domains.models.Coordinate;
import br.com.elo7.sonda.candidato.domains.models.Direction;
import br.com.elo7.sonda.candidato.domains.models.Planet;

import javax.persistence.*;

public class ProbeResponse {

    private Long id;
    private Coordinate coordinate;
    private Planet planet;
    private Direction direction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
