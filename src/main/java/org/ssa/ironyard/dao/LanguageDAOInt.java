package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.Languages;

public interface LanguageDAOInt
{
    Languages insert(Languages language);
    boolean delete(int id);
    int deleteAll();
    Languages read(int id);
    Languages eagerRead(int id);
    List<Languages> readAll();
    List<Languages> eagerReadAll();
}
