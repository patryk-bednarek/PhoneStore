package pl.edu.wszib.phone.store.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;

@Controller
public class CommonController {

    @Autowired
    IPhonesRepository phoneRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage() {
        return "redirect:/main";
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String httpRequestAction() {
        System.out.println("odpalilosie cos");
        return "main";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String httpRequestAction2() {
        System.out.println("kontakt");
        return "account";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String httpRequestAction3() {
        System.out.println("produkty");
        return "products";
    }

}
