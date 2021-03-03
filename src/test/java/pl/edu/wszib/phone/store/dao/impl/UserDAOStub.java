package pl.edu.wszib.phone.store.dao.impl;

import pl.edu.wszib.phone.store.dao.IUserDAO;
import pl.edu.wszib.phone.store.model.User;

public class UserDAOStub implements IUserDAO {
    @Override
    public User getUserByLogin(String login) {
        if(login.equals("piotrek")) {
            return new User();
        }
        return null;
    }

    @Override
    public boolean persistUser(User user) {
        return true;
    }
}
