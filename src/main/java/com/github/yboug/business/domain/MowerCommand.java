package com.github.yboug.business.domain;

import com.github.yboug.exceptions.ParsingException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * MowerCommand define command that can be executed by Mower
 * 
 * @author Youness
 */
@Getter
@AllArgsConstructor
public enum MowerCommand {

	ROTATE_LEFT('G'), ROTATE_RIGHT('D'), FORWARD('A');

	private char code;

	/**
	 * Parse a command from char representation
	 *
	 * @param c
	 * @return the mower command
	 * @throws ParsingException
	 *             if unknown command
	 */
	public static MowerCommand parseCommand(char c) throws ParsingException {

		for (MowerCommand cmd : values()) {
			if (cmd.getCode() == c) {
				return cmd;
			}
		}

		throw new ParsingException("Parse MowerCommand error: " + c);
	}

	/**
	 * Parse commands from String representation
	 *
	 * @param s
	 * @return a list of commands
	 * @throws ParsingException
	 *             if unknown command
	 */
	public static List<MowerCommand> parseCommands(String s)
			throws ParsingException {

		List<MowerCommand> commands = new ArrayList<MowerCommand>();

		if (s != null && s.length() > 0) {

			for (char c : s.toCharArray()) {
				commands.add(parseCommand(c));
			}

			return commands;
		}

		throw new ParsingException("Parse MowerCommands error: " + s);
	}

}
