package com.company;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteFileMockitoTest {

    private static File mockedDirectoryToDelete = new File("C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\source");
    private static File mockedFakeDirectoryToDelete = new File("C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\sourcefake");
    private static DeleteFile deleteFile = null;
    private String file = "C:\\Users\\natalia.rychlowska\\Desktop\\airbus\\aplikacja\\junitmockito\\src\\main\\sourcee";

    @Test
    @Disabled
    public void DeleteFileTest() {

        mockedDirectoryToDelete.mkdir();
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.deleteDirectory(mockedDirectoryToDelete.getPath())).thenThrow(new IOException());
            assertFalse(mockedDirectoryToDelete.exists());

        }

        //

    }

    @Test
    @Disabled
    public void DeleteFileTestMockException() {

        mockedDirectoryToDelete.mkdir();
        try {
            try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
                utilities.when(() -> DeleteFile.moveDirectory("doCallRealMethod()", "dest")).thenThrow(new IOException());
            }
        } catch (Exception e) {
            assertThat(e.getMessage(), is("some value"));
        }
        //        assertThat(caughtException(),
        //                    allOf(
        //                            instanceOf(IOException.class),
        //                            CatchExceptionHamcrestMatchers.hasMessage("test"),
        //                            CatchExceptionHamcrestMatchers.hasNoCause()
        //                    )
        //            );
    }

    @Test
    @Disabled
    public void DeleteFileTestDoThrown() {

        mockedDirectoryToDelete.mkdir();
//        DeleteFile.moveDirectory("doCallRealMethod()", "dest");
        //        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
        //            utilities.when(() -> DeleteFile.deleteDirectory(mockedDirectoryToDelete.getPath()));
        //            assertTrue(mockedDirectoryToDelete.exists());
        //        Throwable throwable = catchThrowable(() -> {
        //            DeleteFile.deleteDirectory(mockedFakeDirectoryToDelete.getPath());
        //        });
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.deleteDirectory("some")).thenThrow(new IOException());


        //                assertThat(throwable).getMessage().contains("test"));
//        assertThatExceptionOfType(IOException.class).isThrownBy(() -> {
//            assertThatThrownBy(() -> DeleteFile.deleteDirectory(mockedFakeDirectoryToDelete.getPath()));
//        });

                assertThatThrownBy(() -> DeleteFile.deleteDirectory("test"))
                        .isInstanceOf(IOException.class)
                        .hasMessageContaining("boom");
    }


    }}

    //        doThrow(new IOException("test")).when(DeleteFile.deleteDirectory(mockedDirectoryToDelete.getPath())));

