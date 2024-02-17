package org.example.webcontacts.controller;

import org.example.webcontacts.data.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
  private final List<Contact> contacts = new ArrayList<>();

  {
    this.contacts.add(new Contact(1, "Иван", "Иванов", "ivan@mail.ru", "+70001234567"));
    this.contacts.add(new Contact(2, "Анастасий", "Прокудин-Горский", "pro@mail.ru", "+79991234567"));
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("contacts", this.contacts);

    return "index";
  }

}