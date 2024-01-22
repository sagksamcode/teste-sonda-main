package br.com.elo7.sonda.candidato.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IllegalFormatException;

public enum IssueEnum {

    BAD_REQUEST_ERROR(1, "Bad Request."),

    MALFORMED_REQUEST_PAYLOAD(2, "Malformed request data."),

    NOT_FOUND_PLANET(3, "Not found planet for this planetId."),

    NOT_FOUND_COMMAND(4, "Not found command."),

    NOT_FOUND_PROBE(5, "Not found probe."),

    WRONG_POSITION_X(6, "PositionX cannot be greater than width planet."),

    WRONG_POSITION_Y(7, "PositionY cannot be greater than height planet."),

    PLANET_EXIST(8, "Planet already exist, use PUT endpoint to update it."),

    PLANETS_NOT_FOUND(9, "Planets not found."),

    PROBE_EXIST(10, "Probe already exist, use PUT endpoint to update it.");

    private final Logger logger = LogManager.getLogger(IssueEnum.class);

    private int code;
    private String message;

    IssueEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getFormattedMessage(final Object... args) {
        if (message == null) {
            return "";
        }

        try {
            return String.format(message, args);
        } catch (final IllegalFormatException e) {
            logger.warn(e.getMessage(), e);
            return message.replace("%s", "");
        }
    }
}
