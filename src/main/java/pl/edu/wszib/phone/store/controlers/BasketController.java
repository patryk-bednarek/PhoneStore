package pl.edu.wszib.phone.store.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class BasketController {

    @Autowired
    IPhonesRepository phonesRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(Model model) {
        model.addAttribute("phones",this.sessionObject.getBasket());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        double sum = 0;
        for (Phone phone : this.sessionObject.getBasket()) {
            sum = sum + phone.getPrice() * phone.getPieces();
        }
        model.addAttribute("sum", sum);
        return "basket";
    }

    @RequestMapping(value = "/addToBasket/{model}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable String model){
        Phone phone = this.phonesRepository.getPhoneByModel(model);
        this.sessionObject.addToBasket(phone.clone());
        return "redirect:/products";
    }
}
