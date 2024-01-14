package org.ibs.repository;

import org.ibs.manager.RepositoryManager;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private ProductRepository productRepository;

    @BeforeEach
    void getConnect() {
        this.productRepository = new ProductRepository(RepositoryManager.getInstance().openConnection());
    }

    @Test
    @DisplayName("Позитивный тест - Добавление товара")
    @Order(1)
    void addProductTestOne() {
        Food food = new Food("Вишня", "FRUIT", 0);
        productRepository.addFood(food);
        assertTrue(productRepository.getAll().contains(food));
    }

    @Test
    @DisplayName("Негативный тест - Добавление товара с существующем индексом")
    @Order(2)
    void addProductNegativeTestTwo() {
        try {
            productRepository.addFood(2L, "Вишня", "FRUIT", false);
            fail("Негативный тест прошел!");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().contains("Unique index or primary key violation"));
        }

    }

    @Test
    @DisplayName("Позитивный тест - Добавление товара")
    @Order(3)
    void addProductTestThree() {
        Food food = new Food("Гранат", "FRUIT", 1);
        productRepository.addFood(food);
        assertTrue(productRepository.getAll().contains(food));
    }

    @Test
    @DisplayName("Тест получения всех товаров")
    @Order(4)
    void getAllProductTest() {
        assertNotNull(productRepository.getAll());
    }

    @Test
    @DisplayName("Тест удаления товаров")
    @Order(5)
    void deleteFoodByNameOne() {
        assertTrue(productRepository.deleteByName("Вишня") > 0);
    }

    @Test
    @DisplayName("Тест удаления товаров")
    @Order(6)
    void deleteFoodByNameTwo() {
        assertTrue(productRepository.deleteByName("Гранат") > 0);
    }

    @AfterAll
    static void closeConnect() {
        RepositoryManager.getInstance().closeConnection();
    }
}
