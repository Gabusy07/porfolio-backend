package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Contact;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Contactdao {
    public void addContact(Contact c);
    public List<Contact> getAll();
    public void deleteContact(int id);
    public void editContact(int id, Contact editedContact);
}
