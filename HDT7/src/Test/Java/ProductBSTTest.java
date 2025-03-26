package Test.Java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import Main.Java.ProductBST ;
import Main.Java.Product;

class ProductBSTTest {
    private ProductBST productBST;
    private static final String TEST_CSV = "src/test/resources/test_products.csv";

    @BeforeEach
    void setUp() throws IOException {
        productBST = new ProductBST();
        // Crear un archivo CSV de prueba pequeño
        productBST.loadFromCSV(TEST_CSV);
    }

    @Test
    void searchBySKUExistingProduct() {
        Product found = productBST.searchBySKU("SKU001");
        assertNotNull(found);
        assertEquals("SKU001", found.getSku());
        assertEquals("Producto 1", found.getProductName());
    }

    @Test
    void searchBySKUNonExistentProduct() {
        Product found = productBST.searchBySKU("SKU999");
        assertNull(found);
    }

    @Test
    void displayProductsAscendingByPrice() {
        // Esta prueba es más visual, podrías capturar la salida para verificarla
        assertDoesNotThrow(() -> productBST.displayProductsAscendingByPrice());
    }

    @Test
    void displayProductsDescendingByPrice() {
        // Esta prueba es más visual, podrías capturar la salida para verificarla
        assertDoesNotThrow(() -> productBST.displayProductsDescendingByPrice());
    }
}
