package CajeroProgramaciónGenerica;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> denominaciones = new ArrayList<>(Arrays.asList(500, 200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> stock = new ArrayList<>(Arrays.asList(5, 50, 30, 100, 20, 50, 50, 20, 100));

        Cajero<Integer> banamex = new Cajero<>(denominaciones, stock);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la cantidad: ");
        int cantidad = scanner.nextInt();
        banamex.setCantidad(cantidad);

        List<Integer> cambio = banamex.darCambio();
        System.out.println("Distribución del cambio (cantidad de cada denominación):");
        System.out.println(cambio);
        banamex.mostrarCambio(cambio);
    }
}