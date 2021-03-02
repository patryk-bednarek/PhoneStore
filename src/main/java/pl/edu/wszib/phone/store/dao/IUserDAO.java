package pl.edu.wszib.phone.store.dao;

import pl.edu.wszib.phone.store.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean persistUser(User user);
}
