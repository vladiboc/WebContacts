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

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("contacts", this.contacts);

    return "index";
  }

}