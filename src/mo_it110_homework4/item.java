package mo_it110_homework4;

abstract class Item {
    protected double price;

    public Item(double price) {
        this.price = price;
    }

    public abstract double calculateSales();
}