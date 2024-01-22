package br.com.elo7.sonda.candidato.exceptions;

public class NotFoundException extends GlobalException{

    private static final long serialVersionUID = 1L;

    protected NotFoundException(final Issue issue){
        super(issue);
    }

    public static NotFoundException planetNotFound() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_PLANET));
    }

    public static NotFoundException commandNotFound() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_COMMAND));
    }

    public static NotFoundException probeNotFound() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_PROBE));
    }

    public static NotFoundException planetsNotFound() {

        return new NotFoundException(new Issue(IssueEnum.PLANETS_NOT_FOUND));
    }
}
