package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiPizza extends AbstractPizzaOrderDecorator {
    public SalamiPizza(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getComponents() {
        return super.getComponents() + ", salami";
    }
}
