package rowan.ood.dipizza.factory.di;

/**
 *
 *
 * @author Dr. Baliga
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rowan.ood.dipizza.factory.pizzaaf.NYPizzaIngredientFactory;
import rowan.ood.dipizza.factory.pizzaaf.PizzaIngredientFactory;
//import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("rowan.ood.dipizza.factory.di")
public class Config {

    @Bean
    public PizzaIngredientFactory factory() {
        return new NYPizzaIngredientFactory();
    }

}
