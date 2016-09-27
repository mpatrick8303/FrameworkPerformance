package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.DomainObject;
import org.ssa.ironyard.model.Framework;

public interface ORMInterface<T extends DomainObject>
{
    String projection();
    String table();
    T map(ResultSet results) throws SQLException;
    T eagerMap(ResultSet results) throws SQLException;
    String prepareInsert();
    String prepareRead();
    String prepareReadAll();
    String pepareEagerRead();
    String pepareEagerReadAll();
    String prepareDelete();
    String prepareDeleteAll();
   
   




   
    
    
}
