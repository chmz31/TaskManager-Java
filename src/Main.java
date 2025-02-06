import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        manager.getTasks().addAll(FileHandler.loadTasks());

        while (true) {
            System.out.println("\n1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir y guardar");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Descripción de la tarea: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.print("Número de tarea a completar: ");
                    int completeIndex = scanner.nextInt() - 1;
                    manager.completeTask(completeIndex);
                    break;
                case 4:
                    System.out.print("Número de tarea a eliminar: ");
                    int removeIndex = scanner.nextInt() - 1;
                    manager.removeTask(removeIndex);
                    break;
                case 5:
                    FileHandler.saveTasks(manager.getTasks());
                    System.out.println("Tareas guardadas. Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}