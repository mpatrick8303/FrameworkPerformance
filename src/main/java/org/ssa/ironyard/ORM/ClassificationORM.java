package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Classifications;
import org.ssa.ironyard.model.Languages;

public class ClassificationORM implements ORMInterface<Classifications>
{
    @Override
    public String projection()
    {
        return "ID, Classification";
    }

    @Override
    public String table()
    {
        return "classifications";
    }

    @Override
    public Classifications map(ResultSet results) throws SQLException
    {
        Classifications c = new Classifications(results.getInt("ID"), results.getString("Classification"));
        return c;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert into " + table() + " (ID, Classification) Values(?,?)";
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
    public Classifications eagerMap(ResultSet results) throws SQLException
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
