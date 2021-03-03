package pl.edu.wszib.phone.store.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.phone.store.dao.IOrderDAO;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.dao.IUserDAO;
import pl.edu.wszib.phone.store.dao.impl.OrderDAOStub;
import pl.edu.wszib.phone.store.dao.impl.PhoneDAOStub;
import pl.edu.wszib.phone.store.dao.impl.UserDAOStub;

@Configuration
@ComponentScan(basePackages =
        {
                "pl.edu.wszib.phone.store.controllers",
                "pl.edu.wszib.phone.store.services.impl",
                "pl.edu.wszib.phone.store.session"
        })
public class TestConfiguration {

   /* @Bean
    public IPhoneDAO phoneDAO() {
        return Mockito.mock(IPhoneDAO.class);
    }

    @Bean
    public IOrderDAO orderDAO() {
        return Mockito.mock(IOrderDAO.class);
    }

    @Bean
    public IUserDAO userDAO() {
        return Mockito.mock(IUserDAO.class);
    }*/
}
