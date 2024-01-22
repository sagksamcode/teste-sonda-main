package br.com.elo7.sonda.candidato.domains.models.vos.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProbeRequest {

    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    @Min(1)
    private Long planetId;
    @NotEmpty
    private String name;
    @NotNull
    @Min(1)
    private int  positionX;
    @NotNull
    @Min(1)
    private int  positionY;
    @NotEmpty
    private String direction;

    public Long getId() {
        return id;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public String getName() {
        return name;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getDirection() {
        return direction;
    }
}
