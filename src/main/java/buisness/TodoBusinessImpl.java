package buisness;

import java.util.ArrayList;
import java.util.List;

//It's called SUT system under test
// TodoService Dependency
//Implementacja biznesowa TodoServiceu w kontruktorze mamy todoService więc przekazujemy wartośc obiektu toDoservice dalej
public class TodoBusinessImpl {

    private TodoService todoService;

    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteNotTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                todoService.deleteToDo(todo);
            }
        }
    }
}
