package spy;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//nie używamy spy, używamy go w legacy kodzie, trudny w utrzymaniu, unikamy ich, ponieważ używamy prawdziwej implementacji
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {// spy pozwala skorzystać z implementacji danej funkcji
    //gdybyśmy zmienili spy na mock aservja z 1 lini byłaby fail
    @Test
    public void testSpy() {
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());
    }

    @Test
    public void testSpyVerify() {
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");// sprawdzamy czy to się naprawde wydarzyło
        verify(arrayListSpy, never()).clear();
        assertEquals(1, arrayListSpy.size());
    }

    @Disabled
    @Test
    public void testSpyVerifyMock() {
        List arrayListSpy = mock(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();
        assertEquals(1, arrayListSpy.size());//tutaj będzie fail bo nie wchodzimy w implementacje
    }
}
