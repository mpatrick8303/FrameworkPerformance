package org.ssa.ironyard.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.dao.FES_WSDAO;
import org.ssa.ironyard.dao.FrameworkDAO;
import org.ssa.ironyard.dao.LanguagesDAO;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.jdbc.MysqlDataSource;

public class FrameworkServicesTest
{
    FrameworkDAO frame;
    LanguagesDAO lan;
    FES_WSDAO fes;
    FrameworkServicesInt fs;
    
    static final String URL = "jdbc:mysql://localhost/framework_jsonperformance?" + "user=root&password=root&" + "useServerPrepStmts=true";
    
    //@Before
    public void setup()
    {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        frame = new FrameworkDAO(mysqlDataSource);
        lan = new LanguagesDAO(mysqlDataSource);
        fes = new FES_WSDAO(mysqlDataSource);
        fs = new FrameworkServices(frame,lan,fes);
        
        frame.deleteAll();
        lan.deleteAll();
        fes.deleteAll();
    }
    
    //@Test
    public void testSetupData()
    {
        //System.out.println("hell");
        fs.setupDatabase();
    }
    
    //@Test
    public void testInsertService()
    {
        Framework f = new Framework("yellow",8,16,32,64,128,256,new Languages("toooooo"),new FrontEndServer_WebServer("nooooooooo"),900000);
        fs.insertFramework(f);
    }
    
    //@Test
    public void testDisplayFrameworks()
    {
        List<Framework> fsList = fs.displayFrameworks();
        
        List<Framework> fList = frame.readAll();
        
        assertTrue(fsList.equals(fList));
    }
    
    //@Test
    public void testDisplayFramework()
    {
        int id = 245;
        
        Framework f = fs.displayFramework(id);
        
        
        
        Languages l = new Languages(294,"Perl");
        FrontEndServer_WebServer ft = new FrontEndServer_WebServer(530,"Starman");
        Framework ff = new Framework(245,"web-simple",18401,21375,19899,19368,19258,19119,l,ft,0);
        
        assertTrue(f.deeplyEquals(ff));
    }

}
