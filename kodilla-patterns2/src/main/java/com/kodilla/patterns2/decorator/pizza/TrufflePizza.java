package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TrufflePizza extends AbstractPizzaOrderDecorator {
    public TrufflePizza(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getComponents() {
        return super.getComponents() + ", mascarphone, salami piccante, olives, truffle sauce";
    }
}
