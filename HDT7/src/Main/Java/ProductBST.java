package Main.Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Main.Java.Product;

public class ProductBST {
    private BST<Product> bst;

    public ProductBST() {
        bst = new BST<>();
    }

    protected BST<Product>.Node<Product> getRootForTesting() {
        return bst.getRoot();
    }

    public void loadFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Para saltar el encabezado

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length >= 5) {
                    String sku = values[0].trim();
                    double priceRetail = Double.parseDouble(values[1].trim());
                    double priceCurrent = Double.parseDouble(values[2].trim());
                    String productName = values[3].trim();
                    String category = values[4].trim();

                    Product product = new Product(sku, priceRetail, priceCurrent, productName, category);
                    bst.insert(product);
                }
            }
        }
    }

    public Product searchBySKU(String sku) {
        Product dummy = new Product(sku, 0, 0, "", "");
        return bst.search(dummy);
    }

    public void displayProductsAscendingByPrice() {
        List<Product> products = getAllProducts();
        products.sort(Comparator.comparingDouble(Product::getPriceCurrent));

        System.out.println("\nProductos ordenados por precio ascendente:");
        products.forEach(System.out::println);
    }

    public void displayProductsDescendingByPrice() {
        List<Product> products = getAllProducts();
        products.sort(Comparator.comparingDouble(Product::getPriceCurrent).reversed());

        System.out.println("\nProductos ordenados por precio descendente:");
        products.forEach(System.out::println);
    }

    private List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        collectProducts(bst.getRoot(), products);
        return products;
    }

}