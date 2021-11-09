package buisness;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TdoBuinessImplBDD {
    @Test
    public void todoBusinessImplMockTest_BDD() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> toDo = Arrays.asList("1", " 2", "some", "Learn Spring ", "Spring tool");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(toDo);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDo);
        List<String> filterStaff = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filterStaff.size()).isEqualTo(2);
        assertEquals(2, filterStaff.size());
        assertEquals("Learn Spring ", filterStaff.get(0));
        assertTrue(filterStaff.get(0).contains("Learn"));
    }
}
