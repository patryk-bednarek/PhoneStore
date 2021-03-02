package pl.edu.wszib.phone.store.model;

public class Phone {

    private int id;
    private String brand;
    private String model;
    private String software;
    private double price;
    private int pieces;


    public Phone(int id, String brand, String model, String software, double price, int pieces) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.software = software;
        this.price = price;
        this.pieces = pieces;
    }

    public Phone() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Phone clone() {
        return new Phone(this.id, this.brand, this.model, this.software, this.price, this.pieces);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", software='" + software + '\'' +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
    }


}


