package br.com.hossomi.bar.model;

public enum Product {
    HAMBURGER("Hamburger", 5.00),
    PASTA("Pasta", 7.50),
    FULL_MEAL("Full meal", 15.00),
    JUICE("Juice", 3.00),
    BEER("Beer", 4.50);

    private final String name;
    private final double cost;

    Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
