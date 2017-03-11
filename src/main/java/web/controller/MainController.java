package web.controller;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import web.entity.TicketForm;

@Controller
@Repository
@RequestMapping(value = "/")
@SessionAttributes(types = TicketForm.class)
public class MainController {
    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(TicketForm ticketForm) {

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(TicketForm ticketForm) {
        if (ticketForm.getTicketNumber() > 10 || ticketForm.getTicketNumber() < 1) {
            return "error";
        }
        return "name_surname";
    }


    @RequestMapping(value = "/name_surname", method = RequestMethod.POST)
    public String nameSurname(TicketForm ticketForm) {
        return "credit";
    }

    @Transactional
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public String credit(TicketForm ticketForm) {
        try {
            System.out.println(sessionFactory.getCurrentSession().save(ticketForm));
        } catch (HibernateException he) {
            return "error";
        }
        return "complete";
    }

}
