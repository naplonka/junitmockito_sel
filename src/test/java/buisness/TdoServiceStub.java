package buisness;

import java.util.Arrays;
import java.util.List;

//Stub is dummy class która implementuje logike TodoServicu, pamiętajmy że biznesowe wykorzystanie tej implementacji jest
//w klasie TodoBusisnessImpl
public class TdoServiceStub implements TodoService{

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("1", " 2", "some", "Learn Spring ", "Spring tool");
    }

    @Override
    public void deleteToDo(String user) {

    }
}
