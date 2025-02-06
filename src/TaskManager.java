import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i));
            }
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
