package pl.edu.wszib.phone.store.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.phone.store.configuration.TestConfiguration;
import pl.edu.wszib.phone.store.dao.IOrderDAO;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.dao.IUserDAO;
import pl.edu.wszib.phone.store.model.User;
import pl.edu.wszib.phone.store.model.view.RegistrationModel;
import pl.edu.wszib.phone.store.services.IUserService;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @MockBean
    IPhoneDAO phoneDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Resource
    SessionObject sessionObject;

    @Before
    public void configureMocks() {
        Mockito.when(this.userDAO.getUserByLogin("karol")).thenReturn(null);
        Mockito.when(this.userDAO.persistUser(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(this.userDAO.getUserByLogin("piotrek")).thenReturn(new User());
        Mockito.when(this.userDAO.getUserByLogin("patryk")).thenReturn(generateUser());
        Mockito.when(this.userDAO.getUserByLogin("jan")).thenReturn(null);

    }


    @Test
    public void registerTest() {
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("karol");
        registrationModel.setPass("karol111");
        registrationModel.setPass2("karol111");


        boolean result = userService.register(registrationModel);

        Assert.assertTrue(result);
    }

    @Test
    public void registerLoginIncorrectTest() {
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("piotrek");
        registrationModel.setPass("pioterk000");
        registrationModel.setPass2("pioterk000");



        boolean result = userService.register(registrationModel);

        Assert.assertFalse(result);
    }

    @Test
    public void correctAuthenticationTest() {
        User user = new User();
        user.setLogin("patryk");
        user.setPass("patryk");


        this.userService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectLoginAuthenticationTest() {
        User user = new User();
        user.setLogin("jan");
        user.setPass("jan");


        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectPassTest() {
        User user = new User();
        user.setLogin("patryk");
        user.setPass("patryk1234");


        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    private User generateUser() {
        User user = new User();
        user.setId(5);
        user.setLogin("patryk");
        user.setPass("patryk");
        user.setRole(User.Role.USER);

        return user;
    }
}
