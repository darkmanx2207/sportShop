package com.jdriven.ng2boot.daoImpl.Impl;

import com.jdriven.ng2boot.dao.ProteinDao;
import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.entity.ProteinType;
import com.jdriven.ng2boot.model.TablePageRequest;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProteinDaoImpl implements ProteinDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProteinDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Protein getProtein(long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Protein.class);
        criteria.add(Restrictions.eq("id", id));

        Protein protein = (Protein) criteria.uniqueResult();
        return protein;
    }

    @Override
    public List<Protein> getListofProteins(TablePageRequest tablePageRequest) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Protein.class);
        criteria.add(Restrictions.eq("type", tablePageRequest.getType()));

        List<Protein> listProteins = criteria.list();
        return listProteins;
    }
}
