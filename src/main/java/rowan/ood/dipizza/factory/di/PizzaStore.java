package rowan.ood.dipizza.factory.di;

/**
 *
 * Pizza store using (constructor) dependency injection
 *
 * @author Dr. Baliga
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rowan.ood.dipizza.factory.pizzaaf.*;

@Component
public class PizzaStore {

//	@Autowired
	PizzaIngredientFactory ingredientFactory;

	@Autowired
	public PizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory =  ingredientFactory;
	}

	// createPizza went from being setup as a (abstract) factory method
	// to having an implementation. This has come to be since the ingredient factory
	// is being provided using DI.

	Pizza createPizza(String item) {

		Pizza pizza = null;

		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName(ingredientFactory.getName()+ " cheese pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName(ingredientFactory.getName()+ " veggie pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName(ingredientFactory.getName()+ " clam pizza");

		} else if (item.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName(ingredientFactory.getName()+ " pepperoni pizza");

		}
		return pizza;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
