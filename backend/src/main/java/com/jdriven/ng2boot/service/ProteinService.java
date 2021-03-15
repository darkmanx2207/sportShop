package com.jdriven.ng2boot.service;

import com.jdriven.ng2boot.dao.ProteinDao;
import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.model.Image;
import com.jdriven.ng2boot.model.TablePageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ProteinService {

    private final ProteinDao proteinDao;

    @Autowired
    public ProteinService(ProteinDao proteinDao) {
        this.proteinDao = proteinDao;
    }

    public Protein getProtein(long id) {
        return proteinDao.getProtein(id);
    }

    public Image getImage(long proteinID) {
        Protein prt = proteinDao.getProtein(proteinID);
        String encodeBase64;
        encodeBase64 = Base64.getEncoder().encodeToString(prt.getImage());
        Image image = new Image();
        image.setImage(encodeBase64);
        return image;
    }

    public List<Protein> getListofProteins(TablePageRequest tablePageRequest) {
        return proteinDao.getListofProteins(tablePageRequest);
    }
}
