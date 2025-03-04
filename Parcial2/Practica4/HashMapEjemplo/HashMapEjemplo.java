package HashMapEjemplo;

import java.util.HashMap;
import java.util.Map;

public class HashMapEjemplo {
    public static void main(String[] args) {
        // Crear un HashMap para almacenar nombres de estudiantes y sus calificaciones
        Map<String, Integer> calificaciones = new HashMap<>();

        // Agregar elementos al HashMap
        calificaciones.put("Juan", 85);
        calificaciones.put("Maria", 90);
        calificaciones.put("Carlos", 78);
        calificaciones.put("Ana", 95);

        // Mostrar el HashMap
        System.out.println("Calificaciones: " + calificaciones);

        // Obtener la calificación de un estudiante específico
        String nombre = "Maria";
        if (calificaciones.containsKey(nombre)) {
            int calificacion = calificaciones.get(nombre);
            System.out.println(nombre + " tiene una calificación de: " + calificacion);
        } else {
            System.out.println(nombre + " no está en el registro.");
        }

        // Modificar la calificación de un estudiante
        calificaciones.put("Carlos", 82); // Actualiza la calificación de Carlos
        System.out.println("Calificaciones actualizadas: " + calificaciones);

        // Eliminar un estudiante del HashMap
        calificaciones.remove("Ana");
        System.out.println("Calificaciones después de eliminar a Ana: " + calificaciones);

        // Recorrer el HashMap
        System.out.println("\nRecorriendo el HashMap:");
        for (Map.Entry<String, Integer> entry : calificaciones.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Calificación: " + entry.getValue());
        }

        // Verificar si el HashMap está vacío
        System.out.println("¿El HashMap está vacío? " + calificaciones.isEmpty());

        // Tamaño del HashMap
        System.out.println("Número de estudiantes: " + calificaciones.size());
    }
}