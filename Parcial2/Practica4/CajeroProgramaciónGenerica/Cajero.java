package CajeroProgramaciónGenerica;

import java.util.List;
import java.util.ArrayList;

public class Cajero<T extends Number & Comparable<T>> {

    private final List<T> denominaciones;
    private final List<T> stock;
    private T cantidad; // monto a cambiar

    public Cajero(List<T> denominaciones, List<T> stock) {
        this.denominaciones = denominaciones;
        this.stock = stock;
    }

    public void setCantidad(T cantidad) {
        this.cantidad = cantidad;
    }

    public List<Integer> darCambio() {
        int restante = cantidad.intValue();
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < denominaciones.size(); i++) {
            resultado.add(0);
        }

        while (restante > 0) {
            boolean usadoAlgunaVez = false;

            for (int i = 6; i < denominaciones.size(); i++) {
                int den = denominaciones.get(i).intValue();
                int stk = stock.get(i).intValue();
                if (den <= restante && stk > 0) {
                    resultado.set(i, resultado.get(i) + 1);
                    stock.set(i, (T) Integer.valueOf(stk - 1));
                    restante -= den;
                    usadoAlgunaVez = true;
                    if (restante == 0) break;
                }
            }
            if (restante == 0) break;
            for (int i = 0; i < 6 && restante > 0; i++) {
                int den = denominaciones.get(i).intValue();
                int stk = stock.get(i).intValue();
                if (den <= restante && stk > 0) {
                    resultado.set(i, resultado.get(i) + 1);
                    stock.set(i, (T) Integer.valueOf(stk - 1));
                    restante -= den;
                    usadoAlgunaVez = true;
                    if (restante == 0) break;
                }
            }
            if (!usadoAlgunaVez) {
                System.out.println("No se puede dar el cambio exacto con el Stock Actual.");
                break;
            }
        }
        return resultado;
    }

    public void mostrarCambio(List<Integer> cantidades) {
        for (int i = 0; i < denominaciones.size(); i++) {
            if (cantidades.get(i) > 0) {
                System.out.println(cantidades.get(i) + " de " + denominaciones.get(i));
            }
        }
    }
}