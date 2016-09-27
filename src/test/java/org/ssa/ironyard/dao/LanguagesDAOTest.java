package org.ssa.ironyard.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.jdbc.MysqlDataSource;

public class LanguagesDAOTest
{
    
    Languages java;
    static String URL = "jdbc:mysql://localhost/framework_jsonperformance?" + "user=root&password=root&" + "useServerPrepStmts=true";
    LanguageDAOInt lan;
    MysqlDataSource mysqlDataSource = new MysqlDataSource();
    
    @Before
    public void setup()
    {
        mysqlDataSource.setUrl(URL);
        lan = new LanguagesDAO(mysqlDataSource);
        
        
        java = new Languages("java");
        lan.deleteAll();
        
    }
    
   // @Test
    public void insertLanTest()
    {
        Languages j = lan.insert(java);
        
        java.setID(j.getID());
        assertTrue(java.equals(j));
        assertTrue(java.deeplyEquals(j));
       
        
    }
    
    //@Test
    public void deleteLanTest()
    {
        Languages j = lan.insert(java);
        
        assertTrue(lan.delete(j.getID()));

        assertTrue(lan.read(j.getID()) == null);
    }

}
