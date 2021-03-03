package pl.edu.wszib.phone.store.rest.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.phone.store.model.User;

@RestController
@RequestMapping(value = "/api")
public class SimpleRestController {

    @RequestMapping(value = "/endpoint", method = RequestMethod.POST)
    public void endpoint1(@RequestBody User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "/endpoint2", method = RequestMethod.GET)
    public User endpoint2() {
        User user = new User();
        user.setId(10);
        user.setLogin("janusz");
        user.setPass("janusz312w123");
        user.setRole(User.Role.USER);

        return user;
    }

    @RequestMapping(value = "/endpoint3/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id, @RequestHeader String pass) {
        User user = new User();
        user.setId(id);
        user.setLogin("janusz");
        user.setPass(pass);
        user.setRole(User.Role.USER);

        return user;
    }

    @RequestMapping(value = "/endpoint4", method = RequestMethod.DELETE)
    public void deleteUserById() {
        System.out.println("DELETE!");
    }
}
