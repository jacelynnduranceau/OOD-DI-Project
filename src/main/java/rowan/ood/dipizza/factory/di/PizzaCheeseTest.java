package rowan.ood.dipizza.factory.di;

/**
 *
 * Unit test for testing pizza store's "cheese pizza" functionality
 *
 * @author Dr. Baliga
 *
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rowan.ood.dipizza.factory.pizzaaf.Pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PizzaCheeseTest {

    static PizzaStore store;

    @BeforeAll
    static void init() {
        // Configure injection using the test fixture
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCheeseTest.class);
        store = context.getBean(PizzaStore.class);
    }

    @Test
    // Simple unit test for testing "cheese pizza" creation
    public void testCheese() {
        Pizza pizza = store.createPizza("cheese");
        pizza.prepare();

        assertEquals(pizza.getCheese().toString(), "Cheese for testing");
        assertEquals(pizza.getDough().toString(), "Play dough");
        assertEquals(pizza.getSauce().toString(), "Fake sauce");

    }
}
