package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exceptions.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book coreJava = new Book(1, "Java", 15, "PhilCo");
    private Smartphone philips = new Smartphone(2, "Philips", 1500, "PhilCo");
    private Product johnsHat = new Product(3, "Hat", 153);
    private Book lore = new Book(4, "PhilCoLore", 123312, "Act");

    @BeforeEach
    public void setUp() {
        repository.save(coreJava);
        repository.save(philips);
        repository.save(johnsHat);
        repository.save(lore);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(3);
        assertArrayEquals(new Product[]{coreJava, philips, lore}, repository.getAll());
    }

    @Test
    public void shouldThrowException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(0));
    }
}