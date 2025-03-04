package controller;
import model.Cajero;
import view.CajeroView;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CajeroController {
    private Cajero<Integer> modelo;
    private CajeroView vista;
    private List<Integer> denominaciones;
    private List<Integer> stock;

    public CajeroController(Cajero<Integer> modelo, CajeroView vista, List<Integer> denominaciones, List<Integer> stock) {
        this.modelo = modelo;
        this.vista = vista;
        this.denominaciones = denominaciones;
        this.stock = stock;
    }

    public void iniciar() {
        try {
            int cantidad = vista.solicitarCantidad();
            modelo.setCantidad(cantidad);
            List<Integer> cambio = modelo.darCambio();
            vista.mostrarCambio(cambio, denominaciones);
        } catch (Exception e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }
}
