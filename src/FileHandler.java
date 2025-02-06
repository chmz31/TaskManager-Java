import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileHandler {
        private static final String FILE_NAME = "tasks.txt";

        public static void saveTasks(List<Task> tasks) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Task task : tasks) {
                    writer.write(task.isCompleted() + ";" + task.getDescription());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al guardar las tareas: " + e.getMessage());
            }
        }

        public static List<Task> loadTasks() {
            List<Task> tasks = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    Task task = new Task(parts[1]);
                    if (Boolean.parseBoolean(parts[0])) {
                        task.complete();
                    }
                    tasks.add(task);
                }
            } catch (IOException e) {
                System.out.println("No se encontraron tareas previas.");
            }
            return tasks;
        }
    }

