package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public interface Descriptiondao {
    ArrayList<Description> readDescription();

    void editDescription(Long id, Description editedDesc);

}
