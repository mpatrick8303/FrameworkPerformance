package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

public class FES_WSORM implements ORMInterface<FrontEndServer_WebServer>
{
    @Override
    public String projection()
    {
        return "ID, FES_WS";
    }

    @Override
    public String table()
    {
        return "Front_End_Server_Web_Server";
    }

    @Override
    public FrontEndServer_WebServer map(ResultSet results) throws SQLException
    {
        FrontEndServer_WebServer fes_ws = new FrontEndServer_WebServer(results.getInt("ID"), results.getString("FES_WS"));
        return fes_ws;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert into " + table() + " (FES_WS) Values(?)";
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
    public FrontEndServer_WebServer eagerMap(ResultSet results) throws SQLException
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
