package br.com.elo7.sonda.candidato.domains.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.awt.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coordinate {

    @Id
    private int id;
    private int verticalAxis;
    private int horizontalAxis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVerticalAxis() {
        return verticalAxis;
    }

    public void setVerticalAxis(int verticalAxis) {
        this.verticalAxis = verticalAxis;
    }

    public int getHorizontalAxis() {
        return horizontalAxis;
    }

    public void setHorizontalAxis(int horizontalAxis) {
        this.horizontalAxis = horizontalAxis;
    }
}
