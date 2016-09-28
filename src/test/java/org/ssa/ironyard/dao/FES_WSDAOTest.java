package org.ssa.ironyard.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.jdbc.MysqlDataSource;

public class FES_WSDAOTest
{

    FrontEndServer_WebServer java;
    static String URL = "jdbc:mysql://localhost/framework_jsonperformance?" + "user=root&password=root&" + "useServerPrepStmts=true";
    FES_WSDAOInt fes;
    MysqlDataSource mysqlDataSource = new MysqlDataSource();
    
    //@Before
    public void setup()
    {
        mysqlDataSource.setUrl(URL);
        fes = new FES_WSDAO(mysqlDataSource);
        
        
        java = new FrontEndServer_WebServer("java");
        fes.deleteAll();
        
    }
    
    //@Test
    public void insertFeTest()
    {
        FrontEndServer_WebServer f = fes.insert(java);
        
        java.setId(f.getId());
        assertTrue(java.equals(f));
        assertTrue(java.deeplyEquals(f));
       
        
    }
    
    //@Test
    public void deleteFeTest()
    {
        FrontEndServer_WebServer f = fes.insert(java);
        
        assertTrue(fes.delete(f.getId()));

        assertTrue(fes.read(f.getId()) == null);
    }

}
