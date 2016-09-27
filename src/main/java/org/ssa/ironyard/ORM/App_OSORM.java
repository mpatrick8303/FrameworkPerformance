package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.App_OS;
import org.ssa.ironyard.model.Languages;

public class App_OSORM implements ORMInterface<App_OS>
{
    @Override
    public String projection()
    {
        return "ID, OS";
    }

    @Override
    public String table()
    {
        return "Application_OS";
    }

    @Override
    public App_OS map(ResultSet results) throws SQLException
    {
        App_OS ao = new App_OS(results.getInt("ID"), results.getString("OS"));
        return ao;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert into " + table() + " (ID, OS) Values(?,?)";
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
    public App_OS eagerMap(ResultSet results) throws SQLException
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
