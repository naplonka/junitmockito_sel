package buisness;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//Test using stub. Problem pojawia się w momencie jak chcemy jak sprawdzać inne rzeczy np sprawdzic null, sprawdzić empty list. Musielibyśmy wtedy stworzyć dużą logike w Stub'a dlatego do akcji wkracza mock!
class TodoBusinessImplTest {

    @Test
    public void test() {
        TodoService todoService = new TdoServiceStub();// tworzymy obiekt todoServiceu wykorzystując implementacje w klasie TdoServiceStub
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);//tworzymy instancje TodoBusinessImpl i jako argument wykorzystujemy todoService
        List<String> filterStaff = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filterStaff.size());
        assertEquals("Learn Spring ", filterStaff.get(0));
        assertTrue(filterStaff.get(0).contains("Learn"));
    }


}
