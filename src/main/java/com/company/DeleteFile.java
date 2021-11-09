package com.company;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Log4j2
public class DeleteFile {
    private static String dltExceptionMessage(File file) {
        return "Delete " + file + " does not exist.";
    }

    private DeleteFile() {
    }

    public static void deleteDirectory(String delete) throws IOException {
        File dltDirectory = new File(delete);
//        if (!dltDirectory.exists()) {
//            log.error("delete");
//        }
            FileUtils.deleteDirectory(dltDirectory);
        log.info("Directory " + dltDirectory + " was deleted.");
    }

    public void deleteFileString(String delete) {
        File dltFile = new File(delete);
        if (!dltFile.exists()) {
            log.error("some text");
        }
        try {
            FileUtils.forceDelete(dltFile);
            log.info("File " + dltFile + " was deleted.");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("File " + dltFile + " was not deleted.");
        }
    }

    public static void moveDirectory(String source, String destination) {
        File srcDirectory = new File(source);
        File dstDirectory = new File(destination);
        try {
            FileUtils.moveDirectoryToDirectory(srcDirectory, dstDirectory, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Moved from " + srcDirectory + " to " + dstDirectory);
    }
}
