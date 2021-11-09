package com.company;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Delete File should")
class DeleteFileTest {

    private static File directoryToDelete = new File("C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\source");
    private static DeleteFile deleteFile = null;
    private String file = "C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\sourcee";

    @BeforeAll
    static void init() {
        directoryToDelete.mkdirs();
    }

    @Test
    @DisplayName("delete file")
    void deletedFile() throws IOException {
        String directory = "C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\sourcee";
        DeleteFile.deleteDirectory(directory);
        assertFalse(directoryToDelete.exists(), () -> "Directory still exist.");
        assertEquals(directory, directoryToDelete.getAbsolutePath());
        assertAll(
                () -> assertFalse(directoryToDelete.exists(), () -> "Directory still exist."),
                () -> assertEquals(directory, directoryToDelete.getAbsolutePath())
        );

        //Thanks assertAll when one from assertion failed the rest assertion are still executed
    }

    @Test
    @Tag("dev")
    @DisplayName("throw exception when there is no directory")
    void throwSourceDirectory() {

        Throwable error = assertThrows(IOException.class, () ->
                DeleteFile.moveDirectory("doCallRealMethod()", "dest"));
        //    assertFalse("some".equals(file));
        assertEquals("Source 'doCallRealMethod()' does not exist", error.getMessage());
    }

    @Test
    void testDeleteInstance() {
        assertNull(deleteFile);
    }

    @Test
    void testDeleteNotThrowsException() {
        //Executable oznacza że trzeba użyć lambda
        assertDoesNotThrow(() -> {
            DeleteFile.moveDirectory("doCallRealMethod()", "dest");
        });

    }

    @AfterAll
    static void clean() {
        deleteFile = null;
        directoryToDelete = null;
    }

    @Test
    void deleteFileString() {
    }
}
