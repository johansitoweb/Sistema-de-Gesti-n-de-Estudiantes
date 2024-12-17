import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;

    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Matrícula: " + matricula;
    }
}

public class Main {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Sistema de Gestión de Estudiantes");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void agregarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la matrícula del estudiante: ");
        String matricula = scanner.nextLine();
        Estudiante estudiante = new Estudiante(nombre, edad, matricula);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado exitosamente.");
    }

    private static void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Lista de Estudiantes:");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    private static void eliminarEstudiante() {
        System.out.print("Ingrese la matrícula del estudiante a eliminar: ");
        String matricula = scanner.nextLine();
        Estudiante estudianteAEliminar = null;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getMatricula().equals(matricula)) {
                estudianteAEliminar = estudiante;
                break;
            }
        }
        if (estudianteAEliminar != null) {
            estudiantes.remove(estudianteAEliminar);
            System.out.println("Estudiante eliminado exitosamente.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}
