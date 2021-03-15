package com.jdriven.ng2boot.dao;

import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.model.TablePageRequest;

import java.util.List;

public interface ProteinDao {

    Protein getProtein(long id);

    List<Protein> getListofProteins(TablePageRequest tablePageRequest);
}
