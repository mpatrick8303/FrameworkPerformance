package org.ssa.ironyard.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.dao.FrameworkDAO;

import com.mysql.cj.jdbc.MysqlDataSource;

public class FrameworkServicesTest
{
    FrameworkDAO frame;
    FrameworkServicesInt fs;
    
    static final String URL = "jdbc:mysql://localhost/framework_jsonperformance?" + "user=root&password=root&" + "useServerPrepStmts=true";
    
    @Before
    public void setup()
    {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        frame = new FrameworkDAO(mysqlDataSource);
        fs = new FrameworkServices(frame);
    }
    
    @Test
    public void test()
    {
        fs.setupDatabase();
    }

}
