package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import web.form.TicketForm;

@Controller
@RequestMapping(value = "/")
@SessionAttributes(types = TicketForm.class)
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "index";
    }
}
