
package prueba1_progra2;


import java.util.Calendar;
import java.util.Scanner;

public class PS3Game extends RentItem {
    private Calendar fechaPublicacion;

    public PS3Game(String codigoItem, String nombreItem) {
        super(codigoItem, nombreItem, 30.0);
        this.fechaPublicacion = Calendar.getInstance();
    }

    public void setFechaPublicacion(int year, int mes, int dia) {
        fechaPublicacion.set(year, mes - 1, dia);
    }

    public String toString() {
        return super.toString() + ", Fecha de Publicacion: " + 
               fechaPublicacion.get(Calendar.DAY_OF_MONTH) + "/" + 
               (fechaPublicacion.get(Calendar.MONTH) + 1) + "/" + 
               fechaPublicacion.get(Calendar.YEAR) + " – PS3 Game";
    }

    public double pagoRenta(int dias) {
        return getPrecioRentaItem() * dias;
    }

    public String submenu() {
        return super.submenu() + "\n2-Actualizar Fecha de Publicacion";
    }


    public void ejecutarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println(this.toString());
                break;
            case 2:
                System.out.print("Ingrese el año en que se publico: ");
                int year = scanner.nextInt();
                System.out.print("Ingrese el mes en que se publico (1-12): ");
                int mes = scanner.nextInt();
                System.out.print("Ingrese el día en que se publico: ");
                int dia = scanner.nextInt();
                setFechaPublicacion(year, mes, dia);
                System.out.println("Fecha en que se publico la actualizacion a: " + dia + "/" + mes + "/" + year);
                break;
            default:
                System.out.println("Esta opción no es valida");
        }
    }
}

