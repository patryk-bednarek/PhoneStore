package pl.edu.wszib.phone.store.model;

import javax.persistence.*;

@Entity(name = "torderposition")
public class OrderPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pieces;
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phone;
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id=" + id +
                ", pieces=" + pieces +
                ", phone=" + phone +
                '}';
    }
}
