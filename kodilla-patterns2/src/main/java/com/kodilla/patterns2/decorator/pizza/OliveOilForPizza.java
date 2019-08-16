package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OliveOilForPizza extends AbstractPizzaOrderDecorator {
    public OliveOilForPizza(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getComponents() {
        return super.getComponents() + " + with olive oil";
    }
}
