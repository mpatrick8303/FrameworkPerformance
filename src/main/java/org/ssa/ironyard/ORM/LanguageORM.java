package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.Languages;

public class LanguageORM implements ORMInterface<Languages>
{

    @Override
    public String projection()
    {
        return "ID, Language";
    }

    @Override
    public String table()
    {
        return "languages";
    }

    @Override
    public Languages map(ResultSet results) throws SQLException
    {
        Languages l = new Languages(results.getInt("ID"), results.getString("Language"));
        return l;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert into " + table() + " (Language) Values(?)";
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
    public Languages eagerMap(ResultSet results) throws SQLException
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
