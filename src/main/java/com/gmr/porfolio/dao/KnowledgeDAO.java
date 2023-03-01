package com.gmr.porfolio.dao;



import com.gmr.porfolio.models.Knowledge;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public interface KnowledgeDAO {

    ArrayList<Knowledge> getAll();

    void editKnowledge(int id, Knowledge editedKnw);

    void deleteKnowledge(int id);

    void addKnowledge(Knowledge knw);


}
