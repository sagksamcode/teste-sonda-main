package br.com.elo7.sonda.candidato.domains.models.vos.requests;

import br.com.elo7.sonda.candidato.domains.models.Command;

import java.util.List;
import java.util.stream.Collectors;

public class CommandRequest {

    private Long probeId;
    private List<String> commands;

    public List<Command> getCommands() {

        return this.commands.stream().map( input -> Command.getInput(input) ).collect(Collectors.toList());
    }

    public Long getProbeId() {
        return probeId;
    }
}
