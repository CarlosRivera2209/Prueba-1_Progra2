package prueba1_progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<RentItem> items = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        
        while (true) {
            System.out.println("------Bienvenido------");
            System.out.println("Menu Principal:");
            System.out.println("1. Agregar Item");
            System.out.println("2. Buscar y Calcular Pago");
            System.out.println("3. Ejecutar el menu secundario");
            System.out.println("4. Imprimir Todo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de Item (MOVIE/PS3): ");
                    String tipo = leer.nextLine().toUpperCase();
                    System.out.print("Ingrese el codigo del Item: ");
                    String codigo = leer.nextLine();
                    
                    if (buscarItem(items, codigo) != null) {
                        System.out.println("El codigo del Item ya existe. Regresando al menú principal.");
                        break;
                    }

                    System.out.print("Ingrese el nombre del Item: ");
                    String nombre = leer.nextLine();
                    
                    if (tipo.equals("MOVIE")) {
                        System.out.print("Ingrese el precio de renta: ");
                        double precioRenta = leer.nextDouble();
                        leer.nextLine(); 
                        items.add(new Movie(codigo, nombre, precioRenta));
                    } else if (tipo.equals("PS3")) {
                        items.add(new PS3Game(codigo, nombre));
                    } else {
                        System.out.println("TIPO INCORRECTO");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el codigo del Item: ");
                    codigo = leer.nextLine();
                    RentItem item = buscarItem(items, codigo);
                    
                    if (item != null) {
                        System.out.println(item.toString());
                        System.out.print("Ingrese los dias a rentar: ");
                        int dias = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Monto a pagar: " + item.pagoRenta(dias));
                    } else {
                        System.out.println("Item No Existe");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del Item: ");
                    codigo = leer.nextLine();
                    item = buscarItem(items, codigo);
                    
                    if (item != null) {
                        System.out.println(item.submenu());
                        System.out.print("Escoja Opcion: ");
                        int subOpcion = leer.nextInt();
                        leer.nextLine(); 
                        item.ejecutarOpcion(subOpcion);
                    } else {
                        System.out.println("Item No Existe");
                    }
                    break;
                case 4:
                    for (RentItem rentItem : items) {
                        System.out.println(rentItem.toString());
                    }
                    break;
                case 5:
                    System.out.println("Adios Inge :)");
                    leer.close();
                    return;
                default:
                    System.out.println("Opcion No Valida");
            }
        }
    }

    private static RentItem buscarItem(ArrayList<RentItem> items, String codigo) {
        for (RentItem item : items) {
            if (item.getCodigoItem().equals(codigo)) {
                return item;
            }
        }
        return null;
    }
}
