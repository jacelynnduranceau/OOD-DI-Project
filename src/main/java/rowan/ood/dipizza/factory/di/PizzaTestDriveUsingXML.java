package rowan.ood.dipizza.factory.di;

/**
 *
 * Demonstrates how to configure injection using XML
 *
 * @author Dr. Baliga
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rowan.ood.dipizza.factory.pizzaaf.Pizza;

public class PizzaTestDriveUsingXML {
 
	public static void main(String[] args) {
//		PizzaStore nyStore = new NYPizzaStore();
//		PizzaStore chicagoStore = new ChicagoPizzaStore();

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
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

	}
}
