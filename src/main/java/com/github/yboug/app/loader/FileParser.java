package com.github.yboug.app.loader;

import com.github.yboug.business.domain.*;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.exceptions.ParsingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileParser allow to Load Context of App
 * 
 * @author Youness
 *
 */
public class FileParser {

	/**
	 *
	 * @param filePath  file path
	 * @return
	 * @throws ParsingException
	 * @throws IOException
	 */
	public static Context buildContextFromFile(String filePath)
			throws ParsingException, IOException {

		int id = 1;
		Map<Mower, List<MowerCommand>> mowers = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		// first line define limit Lawn
		Lawn lawn = new Lawn(Position.parsePositionFromString(line));
		line = br.readLine();
		// load Mowers
		while (line != null) {
			String orientation = line.substring(line.length() - 1,
					line.length());
			String position = line.substring(0, line.length() - 2);
			Orientation currentOrientation = new Orientation(
					OrientationEnum.parseOrientation(orientation));
			Position currentPosition = Position
					.parsePositionFromString(position);

			Mower mower = Mower.builder()
					.currentPosition(currentPosition)
					.currentOrientation(currentOrientation)
					.id(id)
					.build();

			line = br.readLine();
			List<MowerCommand> mowerCommands = MowerCommand.parseCommands(line);
			mowers.put(mower, mowerCommands);
			line = br.readLine();
			id++;
		}
		br.close();
		return Context.builder()
				.lawn(lawn)
				.mowers(mowers)
				.build();

	}
}
