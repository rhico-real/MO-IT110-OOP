package mo_it110_homework4;

class Repair extends Item {
    private int hoursWorked;

    public Repair(double price, int hoursWorked) {
        super(price);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSales() {
        return price * hoursWorked;
    }
}