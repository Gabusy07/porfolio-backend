package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface Descriptiondao {
    Description readDescription();

    void editDescription(Long id, Description editedDesc);

    void deleteDescription(Long id);

    void addDescription(Description desc);
}
