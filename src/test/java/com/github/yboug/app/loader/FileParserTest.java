package com.github.yboug.app.loader;

import com.github.yboug.business.domain.Context;
import com.github.yboug.business.domain.Lawn;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.business.domain.MowerCommand;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.exceptions.ParsingException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.github.yboug.AppTest.filePathNoF;
import static com.github.yboug.AppTest.filePathNok;
import static com.github.yboug.AppTest.filePathUtOk;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParserTest {

    public Context context;


    @Before
    public void setUp() {
    }

    @Test(expected = ParsingException.class)
    public void should_throw_parsing_exception() throws ParsingException, IOException {
        context = FileParser.buildContextFromFile(filePathNok);
    }

    @Test(expected = FileNotFoundException.class)
    public void should_throw_not_found_exception() throws ParsingException, IOException {
        context = FileParser.buildContextFromFile(filePathNoF);
    }

    @Test
    public void should_parse_file() throws ParsingException, IOException {
        context = FileParser.buildContextFromFile(filePathUtOk );
        Lawn lawn = context.getLawn();
        assertThat(lawn.getTopRight().getX()).isEqualTo(5);
        assertThat(lawn.getTopRight().getY()).isEqualTo(5);
        Map<Mower, List<MowerCommand>> mowers = context.getMowers();
        assertThat(mowers.size()).isEqualTo(2);
        mowers.forEach((mower, mowerCommands) -> {
            assertThat(mower.getCurrentOrientation().getOrientationEnum()).isEqualTo(OrientationEnum.NORTH);
            assertThat(mower.getCurrentPosition().getX()).isEqualTo(1);
            assertThat(mower.getCurrentPosition().getY()).isEqualTo(2);
            assertThat(mowerCommands).contains(
                    MowerCommand.ROTATE_LEFT, MowerCommand.FORWARD,
                    MowerCommand.ROTATE_LEFT, MowerCommand.FORWARD,
                    MowerCommand.ROTATE_LEFT, MowerCommand.FORWARD,
                    MowerCommand.ROTATE_LEFT, MowerCommand.FORWARD,
                    MowerCommand.FORWARD);
        });
    }

}