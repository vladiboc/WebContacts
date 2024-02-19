package org.example.webcontacts.controller;

import org.example.webcontacts.data.Contact;
import org.example.webcontacts.exception.IllegalFieldException;
import org.example.webcontacts.util.Checkers;
import org.example.webcontacts.util.InfoMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
  private final List<Contact> contacts = new ArrayList<>();

  // TODO убрать этот блок инициалицации после подключения БД
  {
    this.contacts.add(new Contact(0, "Иван", "Иванов", "ivanov@mail.ru", "+70001234567"));
    this.contacts.add(new Contact(0, "Ия", "Обст", "ia@mail.ru", "+70001234567"));
  }
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("contacts", this.contacts);

    return "index";
  }

  @GetMapping("/contact/create")
  public String showCreateForm(Model model) {
    model.addAttribute("form_name", InfoMsg.CREATION_FORM);
    if (model.getAttribute("contact") == null) {
      model.addAttribute("contact", new Contact());
      model.addAttribute("message", InfoMsg.CREATE_CONTACT);
    }

    return "create_edit";
  }

  @PostMapping("/contact/create")
  public String createTask(@ModelAttribute Contact contact, Model model) {
    // TODO убрать эти секунды после подключния БД
    contact.setId((int) (System.currentTimeMillis() / 1000L));
    try {
      Checkers.checkHtmlInputFields(contact);
    } catch (IllegalFieldException e) {
      model.addAttribute("form_name", InfoMsg.CREATION_FORM);
      model.addAttribute("message", e.getMessage());
      return "create_edit";
    }
    this.contacts.add(contact);

    return "redirect:/";
  }

}
