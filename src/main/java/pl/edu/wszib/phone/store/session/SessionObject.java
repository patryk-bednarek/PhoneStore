package pl.edu.wszib.phone.store.session;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class SessionObject {
    private User loggedUser = null;
    private String info = null;
    private final List<Phone> basket = new ArrayList<>();

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged() {
        return this.loggedUser != null;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        String temp = this.info;
        this.info = null;
        return temp;
    }

    public void addToBasket(Phone phone) {
        for (Phone phoneFromBasket : this.basket) {
            if(phoneFromBasket.getModel().equals(phone.getModel())){
                phoneFromBasket.setPieces(phoneFromBasket.getPieces() + 1);
                return;
            }
        }

        phone.setPieces(1);
        this.basket.add(phone);
    }

    public List<Phone> getBasket() {
        return basket;
    }
}
