package pl.edu.wszib.phone.store.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.services.IPhoneService;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;


@Controller
public class AdminController {

    @Autowired
    IPhoneService phoneService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model m) {
        if(!this.sessionObject.isLogged()){
            return "redirect:/account";
        }
        //Phone phone = this.phonesRepository.getPhoneByModel(model);
        Phone phone = this.phoneService.getPhoneById(id);
        m.addAttribute("phone", phone);
        m.addAttribute("isLogged", this.sessionObject.isLogged());
        m.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Phone phone) {
        if(!this.sessionObject.isLogged()){
            return "redirect:/account";
        }

        this.phoneService.updatePhone(phone);

        return "redirect:/products";
    }
}
