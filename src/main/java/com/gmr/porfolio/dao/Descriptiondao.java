package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
public interface Descriptiondao {

    @Transactional
    ArrayList<Description> readDescription();

    @Transactional
    void replaceDescription( Description editedDesc);

}
