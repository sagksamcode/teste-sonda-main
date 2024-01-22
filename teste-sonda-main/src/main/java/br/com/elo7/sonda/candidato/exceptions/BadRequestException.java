package br.com.elo7.sonda.candidato.exceptions;

public class BadRequestException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private BadRequestException(final Issue issue) {
    super(issue);
  }

  public static BadRequestException invalidPositionX() {

    return new BadRequestException(new Issue(IssueEnum.WRONG_POSITION_X));
  }

  public static BadRequestException invalidPositionY() {

    return new BadRequestException(new Issue(IssueEnum.WRONG_POSITION_Y));
  }

  public static BadRequestException planetExist() {

    return new BadRequestException(new Issue(IssueEnum.PLANET_EXIST));
  }

  public static BadRequestException probeExist() {

    return new BadRequestException(new Issue(IssueEnum.PROBE_EXIST));
  }
}
