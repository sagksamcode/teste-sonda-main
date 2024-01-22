package br.com.elo7.sonda.candidato.domains.models;

import br.com.elo7.sonda.candidato.builders.CoordinateBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

public enum Direction {

	NORTH{
		@Override
		public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {

			int newVerticalPosition = coordinate.getVerticalAxis()+value;
			int maxVerticalPosition = planet.getHeight();

			if(newVerticalPosition > maxVerticalPosition){
				newVerticalPosition -= maxVerticalPosition;
			}
			return new CoordinateBuilder()
					.withVerticalAxisY(newVerticalPosition)
					.withHorizontalAxisX(coordinate.getHorizontalAxis())
					.build();
		}
	}, EAST {
		@Override
		public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {

			int newHorizontalPosition = coordinate.getHorizontalAxis()+value;
			int maxHorizontalPosition = planet.getWidth();

			if(newHorizontalPosition > maxHorizontalPosition){
				newHorizontalPosition -= maxHorizontalPosition;
			}
			return new CoordinateBuilder()
					.withHorizontalAxisX(newHorizontalPosition)
					.withVerticalAxisY(coordinate.getVerticalAxis())
					.build();
		}
	}, SOUTH {
		@Override
		public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {
			int newVerticalPosition = coordinate.getVerticalAxis()-value;
			int maxVerticalPosition = planet.getHeight();

			if(newVerticalPosition < 0){
				newVerticalPosition += maxVerticalPosition;
			}
			return new CoordinateBuilder().withHorizontalAxisX(coordinate.getHorizontalAxis())
					.withVerticalAxisY(newVerticalPosition)
					.build();
		}
	}, WEST {
		@Override
		public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {
			int newHorizontalPosition = coordinate.getHorizontalAxis()-value;
			int maxHorizontalPosition = planet.getWidth();

			if(newHorizontalPosition < 0){
				newHorizontalPosition += maxHorizontalPosition;
			}

			return new CoordinateBuilder()
					.withHorizontalAxisX(newHorizontalPosition)
					.withVerticalAxisY(coordinate.getVerticalAxis())
					.build();
		}
	};

	public abstract Coordinate moveOn(int value,Coordinate coordinate, Planet planet);
}
