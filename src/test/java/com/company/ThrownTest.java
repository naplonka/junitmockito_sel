package com.company;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
public class ThrownTest {

    @Test
    void throwSourceDirectory() {
        Throwable error = assertThrows(IOException.class, () ->
                DeleteFile.moveDirectory("doCallRealMethod()", "dest"));
        assertEquals("Source 'doCallRealMethod()' does not exist", error.getMessage());
    }

    @Test
    void throwSourceDirectoryMock() {
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.moveDirectory("test", "test2")).thenThrow(new IOException());
        }
    }

    @Test
    void catchExceptionDelete() {
        Throwable throwable = catchThrowable(() -> DeleteFile.deleteDirectory("test"));
        assertThat(throwable).isInstanceOf(IOException.class)
                .hasMessage("test");
    }

    @Test
    void catchExceptionMockDelete() {
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.deleteDirectory("test")).thenThrow(new IOException("test"));
            Throwable throwable = catchThrowable(() -> DeleteFile.deleteDirectory("test"));
            assertThat(throwable).isInstanceOf(IOException.class)
            .hasMessage("test");
        }
    }

    @Test
    void catchExceptionMockDeleteAssertThrown() {
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.deleteDirectory("test")).thenThrow(new IOException("Exception message"));
            assertThatExceptionOfType(IOException.class)
                    .isThrownBy(() -> {
                        DeleteFile.deleteDirectory("test");
                    }).withMessage("Exception message");
        }
    }

    @Test
    void catchExceptionMockDeleteAssertThrown1() {
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.deleteDirectory("test")).thenThrow(new IOException("Exception message"));
            assertThatIOException().isThrownBy(() -> {
                DeleteFile.deleteDirectory("test");
            });
        }
    }

    @Test
    void catchExceptionMocCopy() {
        try (MockedStatic<DeleteFile> utilities = Mockito.mockStatic(DeleteFile.class)) {
            utilities.when(() -> DeleteFile.moveDirectory("test", "test")).thenThrow(new IOException("test"));
            Throwable throwable = catchThrowable(() -> DeleteFile.moveDirectory("test", "test"));
            assertThat(throwable).isInstanceOf(IOException.class)
                    .hasMessage("test");
        }
    }
}




