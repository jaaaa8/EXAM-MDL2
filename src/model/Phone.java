package model;

public abstract class Phone {
    protected int id;
    protected String name;
    protected double price;
    protected int amount;
    protected String nxs;

    public Phone(int id, String name, double price, int amount, String nxs) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.nxs = nxs;
    }

    public Phone(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNxs() {
        return nxs;
    }

    public void setNxs(String nxs) {
        this.nxs = nxs;
    }

    public String getData(){
        return id+","+name+","+price+","+amount+","+nxs;
    }
}
