public class Cajero {

    private final int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    private final int[] stock = {5, 50, 30, 100, 20, 50, 50, 20, 100};

    private int cantidad; // monto a cambiar

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int[] darCambio() {
        int[] resultado = new int[denominaciones.length];
        int restante = cantidad;

        while (restante > 0) {
            boolean usadoAlgunaVez = false;

            for (int i = 6; i < denominaciones.length; i++) {
                if (denominaciones[i] <= restante && stock[i] > 0) {
                    resultado[i]++;
                    stock[i]--;
                    restante -= denominaciones[i];
                    usadoAlgunaVez = true;
                    if (restante == 0) break;
                }
            }

            if (restante == 0) break;

            for (int i = 0; i < 6 && restante > 0; i++) {
                if (denominaciones[i] <= restante && stock[i] > 0) {
                    resultado[i]++;
                    stock[i]--;
                    restante -= denominaciones[i];
                    usadoAlgunaVez = true;
                    if (restante == 0) break;
                }
            }

            if (!usadoAlgunaVez) {
                System.out.println("No se puede dar el cambio exacto con el stock actual.");
                break;
            }
        }

        return resultado;
    }

    public void mostrarCambio(int[] cantidades) {
        for (int i = 0; i < denominaciones.length; i++) {
            if (cantidades[i] > 0) {
                System.out.println(cantidades[i] + " de " + denominaciones[i]);
            }
        }
    }
}
