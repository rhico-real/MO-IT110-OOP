package mo_it110_homework4;

class Phone extends Item {
    private int quantitySold;

    public Phone(double price, int quantitySold) {
        super(price);
        this.quantitySold = quantitySold;
    }

    @Override
    public double calculateSales() {
        return price * quantitySold;
    }
}
