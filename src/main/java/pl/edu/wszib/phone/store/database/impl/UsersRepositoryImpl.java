package pl.edu.wszib.phone.store.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.phone.store.database.IUserRepository;


import pl.edu.wszib.phone.store.model.User.Role;
import pl.edu.wszib.phone.store.model.User;

import java.util.ArrayList;
import java.util.List;



public class UsersRepositoryImpl implements IUserRepository {

    private final List<User> users = new ArrayList<>();

    public UsersRepositoryImpl() {
        this.users.add(new User(0,"patryk","patryk", Role.USER));
        this.users.add(new User(0,"admin","admin", Role.ADMIN));
    }


    @Override
    public User authenticate(User user) {

        for(User userFromDatabase: this.users) {
            if(userFromDatabase.getLogin().equals(user.getLogin())
                    && userFromDatabase.getPass().equals(user.getPass())){
                return userFromDatabase;
            }
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (isLoginInDB(user.getLogin())){
            return false;
        }
        this.users.add(user);
        return true;
    }

    private boolean isLoginInDB(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }
}
