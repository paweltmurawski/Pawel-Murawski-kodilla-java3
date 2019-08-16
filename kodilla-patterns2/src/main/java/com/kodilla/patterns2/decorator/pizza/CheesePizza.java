package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CheesePizza extends AbstractPizzaOrderDecorator {
    public CheesePizza(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(8));
    }

    @Override
    public String getComponents() {
        return super.getComponents() + ", feta, gorgonzola, parmezan";
    }
}
