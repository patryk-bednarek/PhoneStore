package pl.edu.wszib.phone.store.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Phone;


@Controller
public class AdminController {

    @Autowired
    IPhonesRepository phonesRepository;

    @RequestMapping(value = "/edit/{model}", method = RequestMethod.GET)
    public String editForm(@PathVariable String model) {
        Phone phone = this.phonesRepository.getPhoneByModel(model);

        return "edit";
    }
}
