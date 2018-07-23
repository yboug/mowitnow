package com.github.yboug;

import com.github.yboug.app.App;
import org.junit.Test;

/**
 * Unit test for  App.
 */
public class AppTest {


    public static final String filePathUtOk = "src/test/resources/testFile_OK_ut.txt";
    public static final String filePathNok = "src/test/resources/testFile_KO.txt";
    public static final String filePathNoF = "src/test/resources/testFile.txt";
    public static final String filePathItOk = "src/test/resources/testFile_OK_it.txt";


    @Test
    public void should_run() {
        App.run(filePathItOk.split(""));
    }
}
