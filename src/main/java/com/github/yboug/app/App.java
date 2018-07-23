package com.github.yboug.app;

import com.github.yboug.app.loader.FileParser;
import com.github.yboug.app.runner.MowerRiderImpl;
import com.github.yboug.business.api.MowerRider;
import com.github.yboug.business.domain.Context;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.exceptions.EngineException;
import com.github.yboug.exceptions.ParsingException;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

/**
 * Main Class to Start Demonstration
 */
@Log
public class App {

    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        // Usage
        if (args.length != 1 || args[0] == null) {
            log.info("Usage : mowitnow.jar <filePath>");
            return;
        }
        String filePath = args[0];
        Context context = null;
        try {
            context = FileParser.buildContextFromFile(filePath);
        } catch (ParsingException | IOException e) {
            log.log(Level.WARNING, e.getMessage());
        }
        MowerRider runner = new MowerRiderImpl();
        List<Mower> run = null;
        try {
            run = runner.run(context);
        } catch (EngineException e) {
            log.log(Level.WARNING, e.getMessage());
        }
        log.info("FINAL RESULT");
        assert run != null;
        run.forEach((mower) ->
                     log.info(String.valueOf(mower.getCurrentPosition().getX() + " " + mower.getCurrentPosition().getY() + " " + mower.getCurrentOrientation().getOrientationEnum() + "\n"))
                );
    }
}
