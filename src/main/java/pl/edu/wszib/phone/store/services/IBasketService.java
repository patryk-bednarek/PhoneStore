package pl.edu.wszib.phone.store.services;

public interface IBasketService {
    double calculateTotal();
    void addPhoneByIdToBasket(int id);
}
