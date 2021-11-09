package buisness.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void letsMockListSizeMethod() {
        List list = mock(List.class);
        when(list.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, list.size());
        assertEquals(3, list.size());
    }

    @Test
    public void letsMockListGet() {
        List list = mock(List.class);
        when(list.get(0)).thenReturn("mockito");

        assertEquals("mockito", list.get(0));
    }

    @Test
    public void letsMockListAnyInt() {
        List list = mock(List.class);
        //argument matcher
        when(list.get(anyInt())).thenReturn("mockito");

        assertEquals("mockito", list.get(12));
    }

    @Test
    public void letsMockListAnyInt_BDD() {
        //Given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willReturn("mockito");

        //When
        String expected = list.get(12);

        //Then
        assertEquals("mockito", expected);
        assertThat("mockito").isEqualTo(expected);
    }

}
