package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    private BST<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void testInsertAndSearch() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        assertNotNull(bst.search(50));
        assertNotNull(bst.search(30));
        assertNotNull(bst.search(20));
        assertNotNull(bst.search(40));
        assertNotNull(bst.search(70));
        assertNotNull(bst.search(60));
        assertNotNull(bst.search(80));
        assertNull(bst.search(100));
    }
    
}
