package buisness;

import java.util.List;

public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void deleteToDo(String user);
}
