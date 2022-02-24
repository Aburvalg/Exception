package netology.repository;

import netology.domain.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import netology.domain.Book;
import netology.domain.Product;
import netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();

    private Product first = new Product(1, "first", 100);
    private Book second = new Book(2, "Want to sleep", 1, "A.Chekhov");
    private Smartphone third = new Smartphone(3, "A-50", 4, "Samsung");

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

    }

    @Test
    void shouldRemoveById() {

        repo.removeById(2);

        Product[] expected = {first, third};
        Product[] actual = repo.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNullId() {

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(4));
    }

}