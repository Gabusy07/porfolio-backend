package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Contact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContactdaoImpl implements Contactdao{

    @PersistenceContext
    private EntityManager em;
    @Override
    public void addContact(Contact c) {
        em.persist(c);
    }

    @Override
    public List<Contact> getAll() {
        String query = "FROM Contact";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void deleteContact(int id) {
        em.remove(this.getContact(id));

    }

    @Override
    public void editContact(int id, Contact editedContact) {
        Contact c = this.getContact(id);
        c = new Contact.Builder().setId(c.getId())
                .setName(c.getName())
                .setIcon(c.getIcon())
                .setLink(c.getLink())
                .build();
        em.merge(c);
    }

    private Contact getContact(int id){
        return em.find(Contact.class, id);
    }
}
