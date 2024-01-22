package br.com.elo7.sonda.candidato.domains.models.vos.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PlanetRequest {

    @NotNull
    @Min(1)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(1)
    private int width;
    @NotNull
    @Min(1)
    private int height;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
