package com.github.yboug.app.runner;

import com.github.yboug.app.loader.FileParser;
import com.github.yboug.app.loader.FileParserTest;
import com.github.yboug.business.api.MowerRider;
import com.github.yboug.business.domain.Context;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.exceptions.EngineException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.github.yboug.AppTest.filePathItOk;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerRiderImplITest {

    Context context;

    MowerRider mowerRider;

    @Before
    public void setUp() throws Exception {
        context = FileParser.buildContextFromFile(filePathItOk);
        mowerRider = new MowerRiderImpl();

    }

    @Test
    public void given_two_mowers_result_should_match_last_position() throws EngineException {
        List<Mower> mowers = mowerRider.run(context);
        assertThat(mowers.size()).isEqualTo(2);
        for(Mower mower : mowers){
            if(mower.getId() == 1)
            {
                //Mower id 1
                assertThat(mower.getCurrentOrientation().getOrientationEnum()).isEqualTo(OrientationEnum.NORTH);
                assertThat(mower.getCurrentPosition().getX()).isEqualTo(1);
                assertThat(mower.getCurrentPosition().getY()).isEqualTo(3);
            } else {
                //Mower id 2
                assertThat(mower.getCurrentOrientation().getOrientationEnum()).isEqualTo(OrientationEnum.EAST);
                assertThat(mower.getCurrentPosition().getX()).isEqualTo(5);
                assertThat(mower.getCurrentPosition().getY()).isEqualTo(1);
            }
        }

    }
}