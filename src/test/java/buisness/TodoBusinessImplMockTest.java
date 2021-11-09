package buisness;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

//jest to samo to ToDoServiceStub przewaga jest taka że mogę zwracać różne wartości
class TodoBusinessImplMockTest {

    @Test
    public void todoBusinessImplMockTest_usingMock() {
        TodoService todoServiceMock = mock(TodoService.class);// to zwraca pustą zamokowaną liste
        List<String> toDo = Arrays.asList("1", " 2", "some", "Learn Spring ", "Spring tool");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDo);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filterStaff = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filterStaff.size());
        assertEquals("Learn Spring ", filterStaff.get(0));
        assertTrue(filterStaff.get(0).contains("Learn"));
    }

    @Test
    public void todoBusinessImplMockTest_usingMock_emptyList() {
        TodoService todoServiceMock = mock(TodoService.class);// to zwraca pustą zamokowaną liste
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filterStaff = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filterStaff.size());
    }

    @Test
    void deleteNotRelatedToSpring_verify() {
        //Given
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> toDo = Arrays.asList("1", "2", "some", "Learn Spring ", "Spring tool");
        given(todoBusiness.retrieveTodosRelatedToSpring("Dummy0")).willReturn(toDo);

        //When
        todoBusiness.deleteNotTodosRelatedToSpring("Dummy0");

        //Then
        verify(todoService).deleteToDo("1");//verify sprawdza czy dana metoda została wywołana w mocku
        verify(todoService, times(1)).deleteToDo("2"); //wywoła się raz
//        verify(todoService, times(2)).deleteToDo("2"); //będzie failed bo nie może wykonać się 2 razy
//        verify(todoService, never()).deleteToDo("1"); //failed bo 1 jest usuwane, powinno być e.g "Learn Spring"
        verify(todoService, never()).deleteToDo("Learn Spring ");
        verify(todoService, atLeastOnce()).deleteToDo("1"); //sprawdzamy czy dana metoda została wywołana przynamniej raz
        assertThat(toDo.size()).isEqualTo(5);
    }
    @Test
    void deleteNotRelatedToSpring_then() {
        //Given
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> toDo = Arrays.asList("1", "2", "some", "Learn Spring ", "Spring tool");
        given(todoBusiness.retrieveTodosRelatedToSpring("Dummy0")).willReturn(toDo);

        //When
        todoBusiness.deleteNotTodosRelatedToSpring("Dummy0");

        //Then
        then(todoService).should(never()).deleteToDo("Learn Spring "); //metoda deleteToDo nie powinna nigdy wywołać "Learn Spring"
    }

    @Test
    void deleteNotRelatedToSpring_argumentCapture() {
        //Najpierw deklarujemy argument
        //Definiujemy argument captor
        //capture argument
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> toDo = Arrays.asList("1", "2", "some", "Learn Spring ", "Spring tool");
        given(todoBusiness.retrieveTodosRelatedToSpring("Dummy0")).willReturn(toDo);

        //When
        todoBusiness.deleteNotTodosRelatedToSpring("Dummy0");

        //Then
        //W tym przykładzie będziemy chcieli przechwycić argument czyli "Learn Sring"
        then(todoService).should(times(3)).deleteToDo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue()).isEqualTo("some");//it failed ponieważ mamy 3 argumenty więc musimy najpierw wywołać metode 3 razy, wtedy będziemy mogli sprawdzić wszystkie 3 argumenty zamiast then(todoService).should(never()).deleteToDo(stringArgumentCaptor.capture()); should(times(3))
        assertThat(stringArgumentCaptor.getAllValues().size()).isEqualTo(3);
    }
}
