package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import web.entity.TicketForm;

@Controller
@RequestMapping(value = "/")
@SessionAttributes(types = TicketForm.class)
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(TicketForm ticketForm) {

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(TicketForm ticketForm) {
        return "name_surname";
    }


    @RequestMapping(value = "/name_surname", method = RequestMethod.POST)
    public String nameSurname(TicketForm ticketForm) {
        return "credit";
    }

    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public String credit(TicketForm ticketForm) {
        return "redirect:/complete";
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public String complete(TicketForm ticketForm) {

        return "complete";
    }
}
