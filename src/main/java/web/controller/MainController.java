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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Transactional
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(TicketForm ticketForm) {
        if (isNumberEntered(ticketForm.getTicketNumber()))
        if (numberBelongsInterval(ticketForm.getTicketNumber())) {
            TicketForm ticketFromBase = sessionFactory.getCurrentSession().get(TicketForm.class, ticketForm.getTicketNumber());
            if (ticketFromBase == null) {
                return "name_surname";
            }
        }
        return "error";
    }


    @RequestMapping(value = "/name_surname", method = RequestMethod.POST)
    public String nameSurname(TicketForm ticketForm) {
        System.out.println(ticketForm.getName());
        System.out.println(ticketForm.getSurname());
        if (isStringEntered(ticketForm.getName()) && isStringEntered(ticketForm.getSurname())) {
            return "credit";
        }
        return "credit";
    }

    @Transactional
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public String credit(TicketForm ticketForm) {
        try {
            if (isCreditCard(ticketForm.getCredit())) {
                System.out.println(sessionFactory.getCurrentSession().save(ticketForm));
                return "complete";
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return "error";
    }

    private static boolean numberBelongsInterval(String string) {
        if (string != null) {
            Integer number = Integer.parseInt(string);
            return number >= 1 && number <= 10;
        }
        return false;
    }

    private static boolean isStringEntered(String string) {
        if (string == null || string.length() == 0) return false;
        Pattern pattern = Pattern.compile("[" + "a-zA-z" + "]" + "*");
        Matcher matcher = pattern.matcher(string.trim());
        return matcher.matches();
    }

    private static boolean isNumberEntered(String string) {
        if (string == null || string.length() == 0) return false;
        Pattern pattern = Pattern.compile("[" + "\\d" + "]" + "*");
        Matcher matcher = pattern.matcher(string.trim());
        return matcher.matches();
    }

    private static boolean isCreditCard(String string) {
        if (string == null || string.length() != 16) return false;
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

}
