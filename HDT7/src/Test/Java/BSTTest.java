package Test.Java;

import Main.Java.BST;
import Main.Java.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Añade estos imports
import java.util.List;
import java.util.ArrayList;

public class BSTTest {
    private BST<Integer> integerBST;
    private BST<Product> productBST;

    @BeforeEach
    void setUp() {
        integerBST = new BST<>();
        productBST = new BST<>();
    }

    @Test
    void insertAndSearchInteger() {
        integerBST.insert(50);
        integerBST.insert(30);
        integerBST.insert(70);

        assertEquals(50, integerBST.search(50));
        assertEquals(30, integerBST.search(30));
        assertEquals(70, integerBST.search(70));
        assertNull(integerBST.search(100));
    }

    @Test
    void insertDuplicateInteger() {
        integerBST.insert(50);
        integerBST.insert(50);
        assertEquals(50, integerBST.search(50));
    }

    @Test
    void insertAndSearchProduct() {
        Product p1 = new Product("SKU001", 100.0, 90.0, "Product 1", "Category 1");
        Product p2 = new Product("SKU002", 200.0, 180.0, "Product 2", "Category 2");

        productBST.insert(p1);
        productBST.insert(p2);

        assertEquals(p1, productBST.search(p1));
        assertEquals(p2, productBST.search(p2));
        assertNull(productBST.search(new Product("SKU999", 0, 0, "", "")));
    }

    @Test
    void searchNonExistentProduct() {
        Product p1 = new Product("SKU001", 100.0, 90.0, "Product 1", "Category 1");
        productBST.insert(p1);

        Product searchFor = new Product("SKU999", 0, 0, "", "");
        assertNull(productBST.search(searchFor));
    }

    @Test
    void insertDuplicateProduct() {
        Product p1 = new Product("SKU001", 100.0, 90.0, "Product 1", "Category 1");
        productBST.insert(p1);
        productBST.insert(p1);

        assertEquals(p1, productBST.search(p1));
    }

    @Test
    void testSize() {
        assertEquals(0, integerBST.size());
        integerBST.insert(50);
        assertEquals(1, integerBST.size());
        integerBST.insert(30);
        assertEquals(2, integerBST.size());
    }

    @Test
    void testContains() {
        integerBST.insert(50);
        assertTrue(integerBST.contains(50));
        assertFalse(integerBST.contains(100));
    }

    @Test
    void testInOrderTraversal() {
        integerBST.insert(50);
        integerBST.insert(30);
        integerBST.insert(70);

        List<Integer> result = integerBST.inOrder();
        assertEquals(3, result.size());
        assertEquals(30, result.get(0));
        assertEquals(50, result.get(1));
        assertEquals(70, result.get(2));
    }

    @Test
    void testInOrderDescending() {
        integerBST.insert(50);
        integerBST.insert(30);
        integerBST.insert(70);

        List<Integer> result = integerBST.inOrderDescending();
        assertEquals(3, result.size());
        assertEquals(70, result.get(0));
        assertEquals(50, result.get(1));
        assertEquals(30, result.get(2));
    }

    @Test
    void testIsEmpty() {
        assertTrue(integerBST.isEmpty());
        integerBST.insert(10);
        assertFalse(integerBST.isEmpty());
    }
}