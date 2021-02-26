package pl.edu.wszib.phone.store.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IPhonesRepository phoneRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage() {
        return "redirect:/main";
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String httpRequestAction(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "main";
    }




    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String httpRequestAction3(Model model) {
        List<Phone> phones = this.phoneRepository.getAllPhones();
        model.addAttribute("phones",phones);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "products";
    }

}
