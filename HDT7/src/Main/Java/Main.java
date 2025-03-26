package Main.Java;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductBST productBST = new ProductBST();
        Scanner scanner = new Scanner(System.in);

        try {
            // Cargar datos del archivo CSV
            productBST.loadFromCSV("src/main/resources/products.csv");
            System.out.println("Datos cargados exitosamente.");

            // Menú de opciones
            while (true) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Buscar producto por SKU");
                System.out.println("2. Listar productos por precio ascendente");
                System.out.println("3. Listar productos por precio descendente");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el SKU a buscar: ");
                        String sku = scanner.nextLine();
                        Product product = productBST.searchBySKU(sku);
                        if (product != null) {
                            System.out.println("\nProducto encontrado:");
                            System.out.println(product);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;
                    case 2:
                        productBST.displayProductsAscendingByPrice();
                        break;
                    case 3:
                        productBST.displayProductsDescendingByPrice();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}