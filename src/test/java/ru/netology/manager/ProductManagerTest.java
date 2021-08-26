package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
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
    public void shouldFind1Item() {
        assertArrayEquals(new Product[]{philips}, manager.searchBy("Philips"));
    }

    @Test
    public void shouldFindNoItem() {
        assertArrayEquals(new Product[]{}, manager.searchBy("Lips"));
    }

    @Test
    public void shouldFind3Item() {
        assertArrayEquals(new Product[]{coreJava, philips, lore}, manager.searchBy("PhilCo"));
    }
}