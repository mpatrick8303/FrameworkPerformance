package org.ssa.ironyard.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.jdbc.MysqlDataSource;

public class FrameworkDAOTest
{

    Languages java;
    FrontEndServer_WebServer resin;
    Framework activeweb;
    static String URL = "jdbc:mysql://localhost/framework_jsonperformance?" + "user=root&password=root&" + "useServerPrepStmts=true";
    FrameworkDAOInt frame;
    LanguageDAOInt lan;
    FES_WSDAOInt fes;
    MysqlDataSource mysqlDataSource = new MysqlDataSource();
    
    //@Before
    public void setup()
    {
        mysqlDataSource.setUrl(URL);
        frame = new FrameworkDAO(mysqlDataSource);
        lan = new LanguagesDAO(mysqlDataSource);
        fes = new FES_WSDAO(mysqlDataSource);
        
        
        
        java = new Languages("java");
        resin = new FrontEndServer_WebServer("resin");
        activeweb = new Framework("activeweb",8,16,32,64,128,256,java,resin,0);
        
        frame.deleteAll();
        lan.deleteAll();
        fes.deleteAll();
        
        
    }
    
    //@Test
    public void testFrameInsert()
    {
       Framework fR = frame.insert(activeweb);
        
       Framework fC = frame.read(fR.getId());
       Framework fEC = frame.eagerRead(fR.getId());

       
       assertTrue(fR.equals(fC));
       assertTrue(fR.deeplyEquals(fEC));
       
       
        
    }
    
    //@Test
    public void testFrameInsertIncluded()
    {
        Languages l = lan.insert(java);
        FrontEndServer_WebServer f = fes.insert(resin);
        Framework fm = frame.insert(activeweb);
        
        Framework hello = new Framework("hello",8,16,32,64,128,256,java,resin,0);
        frame.insert(hello);
        
        assertTrue(lan.readAll().size()==1);
        assertTrue(fes.readAll().size()==1);
        assertTrue(frame.readAll().size()==2);
        
        
        
        
    }
}
