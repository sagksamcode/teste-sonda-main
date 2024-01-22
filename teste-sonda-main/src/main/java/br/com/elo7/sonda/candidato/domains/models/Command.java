package br.com.elo7.sonda.candidato.domains.models;

import br.com.elo7.sonda.candidato.exceptions.NotFoundException;

import java.util.Arrays;

public enum Command {
	FORWARD("M"){ @Override public void run(Probe probe) { probe.moveForward(); }},
	LEFT("L") { @Override public void run(Probe probe) { probe.turnLeft(); }},
	RIGHT("R") { @Override public void run(Probe probe) { probe.turnRight(); }};

	private final String input;

	Command(String input) {
		this.input = input;
	}

	public static Command getInput(String input){
		return Arrays
				.stream(Command.values())
				.filter( command -> command.input.equals(input.toUpperCase()) )
				.findFirst()
				.orElseThrow( () -> NotFoundException.commandNotFound());
	}

	public abstract void run(Probe probe);
}
