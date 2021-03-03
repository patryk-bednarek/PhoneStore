package pl.edu.wszib.phone.store.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.phone.store.configuration.TestConfiguration;
import pl.edu.wszib.phone.store.dao.IOrderDAO;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.dao.IUserDAO;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.services.IBasketService;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class BasketServiceImplTest {

    @Autowired
    IBasketService basketService;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IPhoneDAO phoneDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Resource
    SessionObject sessionObject;

    @Test
    public void calculateBillTest() {
        sessionObject.getBasket().add(new Phone(1,"Iphone","13","iOS",1999,1 ));;
        sessionObject.getBasket().add(new Phone(2,"Samsung","Galaxy Note 10","Android",2999,2 ));
        sessionObject.getBasket().add(new Phone(3,"Motorolla","ZFlip","Android",2599,1 ));

        double expectedResult = 10596;

        double result = this.basketService.calculateTotal();

        Assert.assertEquals(expectedResult, result, 0.01);
    }
}
