
package prueba1_progra2;

import java.util.Scanner;

public class Movie extends RentItem {
    private String estado;

    public Movie(String codigoItem, String nombreItem, double precioRentaItem) {
        super(codigoItem, nombreItem, precioRentaItem);
        this.estado = "ESTRENO";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        return super.toString() + ", Estado: " + estado + " – Movie";
    }

    public double pagoRenta(int dias) {
        double recargo = 0;
        if (estado.equals("ESTRENO") && dias > 2) {
            recargo = (dias - 2) * 50;
        } else if (!estado.equals("ESTRENO") && dias > 5) {
            recargo = (dias - 5) * 30;
        }
        return getPrecioRentaItem() + recargo;
    }

    public String submenu() {
        return super.submenu() + "\n2-Cambiar Estado";
    }

    public void ejecutarOpcion(int opcion) {
        Scanner hola = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println(this.toString());
                break;
            case 2:
                System.out.print("Ingrese el nuevo estado: ");
                String nuevoEstado = hola.nextLine();
                setEstado(nuevoEstado);
                System.out.println("Estado actualizado a: " + nuevoEstado);
                break;
            default:
                System.out.println("La opcion no es valida. Intente de nuevo");
        }
    }
}

