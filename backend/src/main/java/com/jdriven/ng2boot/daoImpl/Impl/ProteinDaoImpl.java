package com.jdriven.ng2boot.daoImpl.Impl;

import com.jdriven.ng2boot.dao.ProteinDao;
import com.jdriven.ng2boot.entity.Protein;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProteinDaoImpl implements ProteinDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProteinDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Protein getProtein() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Protein.class);

        Protein protein = (Protein) criteria.uniqueResult();
        return protein;
    }
}
