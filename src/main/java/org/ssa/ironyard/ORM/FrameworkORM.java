package org.ssa.ironyard.ORM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ssa.ironyard.model.App_OS;
import org.ssa.ironyard.model.Classifications;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Imp_Approach;
import org.ssa.ironyard.model.Languages;

public class FrameworkORM implements ORMInterface<Framework>
{

    @Override
    public String projection()
    {
        return "ID, Framework, 8_Concurrency, 16_Concurrency, 32_Concurrency, 64_Concurrency, 128_Concurrency, 256_Concurrency, Languageid, Front_End_Server_Web_Serverid, Errors";
    }
    

    public String eagerProject()
    {
        return "ID, Framework, 8_Concurrency, 16_Concurrency, 32_Concurrency, 64_Concurrency, 128_Concurrency, 256_Concurency, Languageid, Front_End_Server_Web_Serverid, Errors, Language, FES_WS";
    }

    @Override
    public String table()
    {
        return "framework_performance";
    }

    @Override
    public Framework map(ResultSet results) throws SQLException
    {
        Languages l = new Languages();
        FrontEndServer_WebServer fes_ws = new FrontEndServer_WebServer();

        l.setID(results.getInt("Languageid"));
        fes_ws.setId(results.getInt("Front_End_Server_Web_Serverid"));
        
        Framework f = new Framework(results.getInt("ID"),results.getString("Framework"),results.getInt("8_concurrency"),results.getInt("16_concurrency"),results.getInt("32_concurrency"),results.getInt("64_concurrency"),results.getInt("128_concurrency"),results.getInt("256_concurrency"),l,fes_ws,results.getInt("errors"));
        return f;
    }
    
    @Override
    public Framework eagerMap(ResultSet results) throws SQLException
    {
        Languages l = new Languages();
        FrontEndServer_WebServer fes_ws = new FrontEndServer_WebServer();
        
        l.setID(results.getInt("Languageid"));
        l.setLanguage(results.getString("Language"));
        
        fes_ws.setId(results.getInt("Front_End_Server_Web_Serverid"));
        fes_ws.setFes_WS(results.getString("FES_WS"));


        
        Framework f = new Framework(results.getInt("ID"),results.getString("Framework"),results.getInt("8_concurrency"),results.getInt("16_concurrency"),results.getInt("32_concurrency"),results.getInt("64_concurrency"),results.getInt("128_concurrency"),results.getInt("256_concurrency"),l,fes_ws,results.getInt("errors"));
        return f;
    }

    @Override
    public String prepareInsert()
    {
        return "Insert Into " + table() + "(Framework, 8_Concurrency, 16_Concurrency, 32_Concurrency, 64_Concurrency, 128_Concurrency, 256_Concurrency, Languageid, Front_End_Server_Web_Serverid, Errors) Values (?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String prepareRead()
    {
        return "Select " + projection() + " From " + table() + " Where id=?";
    }
    
    @Override
    public String pepareEagerRead()
    {

        FES_WSORM fesORM = new FES_WSORM(){};
        LanguageORM lORM = new LanguageORM(){};
        
        String build = "Select * " + 
        "From " + table() +
        " Inner Join " + fesORM.table() + 
        " On " + table() + ".Front_End_Server_Web_Serverid=" + fesORM.table() + ".ID" +
        " Inner Join " + lORM.table() + 
        " On  " + table() + ".Languageid=" + lORM.table() + ".ID" +
        " Where " + table() + ".id=?";
        return build;
    }
    
    @Override
    public String pepareEagerReadAll()
    {
        FES_WSORM fesORM = new FES_WSORM(){};
        LanguageORM lORM = new LanguageORM(){};
        
        String build = "Select * " + 
                "From " + table() +
                " Inner Join " + fesORM.table() + 
                " On " + table() + ".Front_End_Server_Web_Serverid=" + fesORM.table() + ".ID" +
                " Inner Join " + lORM.table() + 
                " On  " + table() + ".Languageid=" + lORM.table() + ".ID";
        return build;
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


}
