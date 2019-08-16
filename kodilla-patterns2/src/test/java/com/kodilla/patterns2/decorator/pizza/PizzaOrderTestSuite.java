package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaOrderWithCheeseGetCost() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new CheesePizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getCost());
        //When
        BigDecimal thePizzaCost = thePizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(23), thePizzaCost);
    }

    @Test
    public void testPizzaOrderWithCheeseGetComponents() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new CheesePizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getComponents());
        //When
        String thePizzaComponents = thePizzaOrder.getComponents();
        //Then
        assertEquals("tomato sauce, cheese, feta, gorgonzola, parmezan", thePizzaComponents);
    }

    @Test
    public void testPizzaOrderWithSalamiGetCost() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new SalamiPizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getCost());
        //When
        BigDecimal thePizzaCost = thePizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18), thePizzaCost);
    }

    @Test
    public void testPizzaOrderWithSalamiGetComponents() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new SalamiPizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getComponents());
        //When
        String thePizzaComponents = thePizzaOrder.getComponents();
        //Then
        assertEquals("tomato sauce, cheese, salami", thePizzaComponents);
    }

    @Test
    public void testTrufflePizzaWithOliveOilGetCost() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new TrufflePizza(thePizzaOrder);
        thePizzaOrder = new OliveOilForPizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getCost());
        //When
        BigDecimal thePizzaCost = thePizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(27), thePizzaCost);
    }

    @Test
    public void testTrufflePizzaWithOliveOilGetComponents() {
        //Given
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new TrufflePizza(thePizzaOrder);
        thePizzaOrder = new OliveOilForPizza(thePizzaOrder);
        System.out.println(thePizzaOrder.getComponents());
        //When
        String thePizzaComponents = thePizzaOrder.getComponents();
        //Then
        assertEquals("tomato sauce, cheese, mascarphone, salami piccante, olives, truffle sauce + with olive oil", thePizzaComponents);
    }



}