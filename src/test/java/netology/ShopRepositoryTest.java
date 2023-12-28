package netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    public void addProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "Картофель", 55);
        Product product2 = new Product(15, "Помидоры", 350);
        Product product3 = new Product(20, "Огурцы", 240);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void removeProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "Картофель", 55);
        Product product2 = new Product(15, "Помидоры", 350);
        Product product3 = new Product(20, "Огурцы", 240);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(20);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void excludeIfProductAbsent() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "Картофель", 55);
        Product product2 = new Product(15, "Помидоры", 350);
        Product product3 = new Product(20, "Огурцы", 240);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(25));
    }
}