package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Imp_Approach;
import org.ssa.ironyard.model.Languages;

public class Imp_ApproachORM implements ORMInterface<Imp_Approach>
{
    @Override
    public String projection()
    {
        return "ID, Approach";
    }

    @Override
    public String table()
    {
        return "Implementation_Approach";
    }

    @Override
    public Imp_Approach map(ResultSet results) throws SQLException
    {
        Imp_Approach ia = new Imp_Approach(results.getInt("ID"), results.getString("Approach"));
        return ia;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert into " + table() + " (ID, Approach) Values(?,?)";
    }

    @Override
    public String prepareRead()
    {
        return "Select " + projection() + " From " + table() + " Where id=?";
    }
    
    @Override
    public String prepareReadAll()
    {
        return "Select " + projection() + " From " + table();
    }


    @Override
    public String prepareDelete()
    {
        return "Delete From " + table() + " Where id=?";
    }

    @Override
    public String prepareDeleteAll()
    {
        return "Delete From " + table();
    }

    @Override
    public Imp_Approach eagerMap(ResultSet results) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String pepareEagerRead()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String pepareEagerReadAll()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
