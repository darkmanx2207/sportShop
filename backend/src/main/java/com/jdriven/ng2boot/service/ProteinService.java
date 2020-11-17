package com.jdriven.ng2boot.service;

import com.jdriven.ng2boot.dao.ProteinDao;
import com.jdriven.ng2boot.entity.Protein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProteinService {

    private final ProteinDao proteinDao;

    @Autowired
    public ProteinService(ProteinDao proteinDao) {
        this.proteinDao = proteinDao;
    }

    public Protein getProtein() {
        return proteinDao.getProtein();
    }
}
