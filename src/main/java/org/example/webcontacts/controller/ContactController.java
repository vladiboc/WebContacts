package org.example.webcontacts.controller;

import lombok.RequiredArgsConstructor;
import org.example.webcontacts.data.Contact;
import org.example.webcontacts.exception.IllegalFieldException;
import org.example.webcontacts.service.ContactService;
import org.example.webcontacts.util.Checkers;
import org.example.webcontacts.util.InfoMsg;
import org.example.webcontacts.util.ThKeys;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
  private final ContactService contactService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute(ThKeys.ALL_CONTACTS_KEY, this.contactService.findAll());
    return ThKeys.INDEX;
  }

  @GetMapping("/contact/create")
  public String showCreateForm(Model model) {
    if (model.getAttribute(ThKeys.CONTACT_KEY) == null) {
      model.addAttribute(ThKeys.CONTACT_KEY, new Contact());
      model.addAttribute(ThKeys.MESSAGE_KEY, InfoMsg.CREATE_CONTACT);
    }
    return this.initCreateForm(model);
  }

  @PostMapping("/contact/create")
  public String createTask(@ModelAttribute Contact contact, Model model) {
    // TODO убрать эти секунды после подключния БД
    contact.setId((int)(Math.random() * 1000));
    try {
      Checkers.checkHtmlInputFields(contact);
    } catch (IllegalFieldException e) {
      model.addAttribute(ThKeys.MESSAGE_KEY, e.getMessage());
      return this.initCreateForm(model);
    }
    this.contactService.add(contact);
    return ThKeys.REDIRECT_TO_ROOT_PAGE;
  }

  @GetMapping("/contact/edit/{id}")
  public String showEditForm(@PathVariable int id, Model model) {
    Contact contact = this.contactService.findById(id);
    if (contact != null) {
      model.addAttribute(ThKeys.CONTACT_KEY, contact);
      model.addAttribute(ThKeys.MESSAGE_KEY, InfoMsg.EDIT_CONTACT);
      return this.initEditForm(model);
    }
    return ThKeys.REDIRECT_TO_ROOT_PAGE;
  }

  @PostMapping("/contact/edit")
  public String editTask(@ModelAttribute Contact contact, Model model) {
    try {
      Checkers.checkHtmlInputFields(contact);
    } catch (IllegalFieldException e) {
      model.addAttribute(ThKeys.MESSAGE_KEY, e.getMessage());
      return this.initEditForm(model);
    }
    Contact targetContact = this.contactService.findById(contact.getId());
    if (targetContact != null) {
      this.contactService.update(contact, targetContact);
    }
    return ThKeys.REDIRECT_TO_ROOT_PAGE;
  }

  @GetMapping("/contact/delete/{id}")
  public String deleteContact(@PathVariable int id) {
    Contact targetContact = this.contactService.findById(id);
    if (targetContact != null) {
      this.contactService.delete(targetContact);
    }
    return ThKeys.REDIRECT_TO_ROOT_PAGE;
  }

  private String initCreateForm(Model model) {
    model.addAttribute(ThKeys.FORM_NAME_KEY, InfoMsg.CREATION_FORM);
    model.addAttribute(ThKeys.FORM_ACTION_KEY, ThKeys.ACTION_CREATE);
    return ThKeys.CREATE_EDIT_FORM;
  }
  private String initEditForm(Model model) {
    model.addAttribute(ThKeys.FORM_NAME_KEY, InfoMsg.EDITING_FORM);
    model.addAttribute(ThKeys.FORM_ACTION_KEY, ThKeys.ACTION_EDIT);
    return ThKeys.CREATE_EDIT_FORM;
  }

}
