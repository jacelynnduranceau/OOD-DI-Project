package rowan.ood.dipizza.factory.di;

/**
 *
 * Demonstrates how to configure injection using component scanning
 *
 * @author Dr. Baliga
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rowan.ood.dipizza.factory.pizzaaf.Pizza;


public class PizzaTestDriveUsingCode {
 
	public static void main(String[] args) {
//		PizzaStore nyStore = new NYPizzaStore();
//		PizzaStore chicagoStore = new ChicagoPizzaStore();
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		PizzaStore store = context.getBean(PizzaStore.class);

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
//		pizza = store.orderPizza("cheese");
//		System.out.println("Joel ordered a " + pizza + "\n");

//		pizza = nyStore.orderPizza("clam");
//		System.out.println("Ethan ordered a " + pizza + "\n");
//
//		pizza = chicagoStore.orderPizza("clam");
//		System.out.println("Joel ordered a " + pizza + "\n");
//
//		pizza = store.orderPizza("pepperoni");
//		System.out.println("Ethan ordered a " + pizza + "\n");
//
//		pizza = chicagoStore.orderPizza("pepperoni");
//		System.out.println("Joel ordered a " + pizza + "\n");
//
//		pizza = nyStore.orderPizza("veggie");
//		System.out.println("Ethan ordered a " + pizza + "\n");
//
//		pizza = chicagoStore.orderPizza("veggie");
//		System.out.println("Joel ordered a " + pizza + "\n");
//
	}
}
