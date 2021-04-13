package rowan.ood.dipizza.factory.di;

/**
 *
 * Unit test: Mock fixture injection spec for unit testing
 *
 * @author Dr. Baliga
 *
 */

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rowan.ood.dipizza.factory.pizzaaf.Cheese;
import rowan.ood.dipizza.factory.pizzaaf.Dough;
import rowan.ood.dipizza.factory.pizzaaf.PizzaIngredientFactory;
import rowan.ood.dipizza.factory.pizzaaf.Sauce;

import static org.mockito.Mockito.when;


@Configuration
@ComponentScan("rowan.ood.dipizza.factory")
public class ConfigCheeseTest {

    // Mocked objects, setup for testing cheese pizzas
    @Mock
    PizzaIngredientFactory testFactory;

    @Mock
    Cheese testCheese;

    @Mock
    Dough testDough;

    @Mock
    Sauce testSauce;

    @Bean
    public PizzaIngredientFactory factory() {

        // Create mock objects
        MockitoAnnotations.openMocks(this);

        // Just test the "cheese pizza aspect" of your pizza store
        // Specify mock object behaviors
        when(testCheese.toString()).thenReturn("Cheese for testing");
        when(testFactory.createCheese()).thenReturn(testCheese);

        when(testDough.toString()).thenReturn("Play dough");
        when(testFactory.createDough()).thenReturn(testDough);

        when(testSauce.toString()).thenReturn("Fake sauce");
        when(testFactory.createSauce()).thenReturn(testSauce);

        when(testFactory.getName()).thenReturn("Cheese test factory");

        // NOTE: We do not need to mock the behavior for
        // ingredient factory methods createVeggie, createPepperoni
        // since they are not relevant to testing cheese pizza

        return testFactory;
    }

}
