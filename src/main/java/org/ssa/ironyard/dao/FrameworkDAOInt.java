package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.Framework;

public interface FrameworkDAOInt
{
    Framework insert(Framework framework);
    boolean delete(int id);
    int deleteAll();
    Framework read(int id);
    Framework eagerRead(int id);
    List<Framework> readAll();
    List<Framework> eagerReadAll();
    
}
