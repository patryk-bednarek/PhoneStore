package pl.edu.wszib.phone.store.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Order;
import pl.edu.wszib.phone.store.model.OrderPosition;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.services.IOrderService;
import pl.edu.wszib.phone.store.services.IPhoneService;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    IPhoneService phoneService;

    @Autowired
    IOrderService orderService;

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

    @RequestMapping(value = "/cheaty-do-zapisu-ordera", method = RequestMethod.GET)
    public String zapis() {

        List<Phone> phones = this.phoneService.getAllPhones();

        Order order = new Order();
        order.setStatus(Order.Status.ORDERED);
        order.setUser(this.sessionObject.getLoggedUser());

        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setPieces(1);
        orderPosition1.setPhone(phones.get(0));
        orderPosition1.setOrder(order);

        order.getPositions().add(orderPosition1);

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setPieces(2);
        orderPosition2.setPhone(phones.get(1));
        orderPosition2.setOrder(order);

        order.getPositions().add(orderPosition2);
        order.setPrice(phones.get(0).getPrice() + phones.get(1).getPrice() * 2);

        this.orderService.saveOrder(order);

        return "redirect:/products";
    }

    @RequestMapping(value = "/cheat-do-odczytania-ordera", method = RequestMethod.GET)
    public String odczyt() {

        Order order = this.orderService.getOrderById(1);

        System.out.println(order);

        return "redirect:/products";
    }
}
