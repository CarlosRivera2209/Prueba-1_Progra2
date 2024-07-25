
package prueba1_progra2;

public class RentItem {
    private String codigoItem;
    private String nombreItem;
    private double precioRentaItem;
    private int cantidadCopias;

    public RentItem(String codigoItem, String nombreItem, double precioRentaItem) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.precioRentaItem = precioRentaItem;
        this.cantidadCopias = 0;
    }

    public String toString() {
        return "Codigo de Item: " + codigoItem + "\nNombre de Item: " + nombreItem + 
               "\nPrecio de renta de Item: " + precioRentaItem + 
               "\nCantidad de copias: " + cantidadCopias;
    }

    public double pagoRenta(int dias) {
        return 0;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public double getPrecioRentaItem() {
        return precioRentaItem;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public String submenu() {
        return "1 - Imprimir";
    }

    public void ejecutarOpcion(int opcion) {
        if (opcion == 1) {
            System.out.println(this.toString());
        } else {
            System.out.println("Esta Opcion No es Válida");
        }
    }
}

