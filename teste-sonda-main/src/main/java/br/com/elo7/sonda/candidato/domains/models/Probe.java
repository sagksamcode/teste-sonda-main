package br.com.elo7.sonda.candidato.domains.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

@Entity
public class Probe {

	@Id
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Coordinate coordinate;
	@OneToOne
	private Planet planet;
	@Enumerated(EnumType.STRING)
	private Direction direction;

	private static final LinkedList<Direction> directions = new LinkedList<Direction>(
			Arrays.stream(Direction.values()).toList()
	);

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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public void turnRight(){
		ListIterator<Direction> iterator = directions.listIterator(directions.indexOf(this.direction)+1);
		this.direction = iterator.hasNext() ? iterator.next() : directions.getFirst();
	}

	public void turnLeft(){
		ListIterator<Direction> iterator = directions.listIterator(directions.indexOf(this.direction));
		this.direction = iterator.hasPrevious() ? iterator.previous() : directions.getLast();
	}

	public void moveForward(){
		this.coordinate = this.direction.moveOn(1,this.coordinate,this.planet);
	}
}
