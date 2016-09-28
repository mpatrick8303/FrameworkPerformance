package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssa.ironyard.ORM.FES_WSORM;
import org.ssa.ironyard.ORM.ORMInterface;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.api.jdbc.Statement;

@Component
public class FES_WSDAO extends AbstractDAO<FrontEndServer_WebServer> implements FES_WSDAOInt
{
    @Autowired
    public FES_WSDAO(DataSource datasource)
    {
        super(datasource, new FES_WSORM(){});
    }

    @Override
    public FrontEndServer_WebServer insert(FrontEndServer_WebServer fes_ws)
    {
        FrontEndServer_WebServer f = null;
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet generatedKeys = null;
        
        try
        {
            connection = datasource.getConnection();
            insertStatement = connection.prepareStatement(orm.prepareInsert(),Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, fes_ws.getFes_WS());
            
            if(insertStatement.executeUpdate() > 0)
            {
                generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next())
                {
                    f = new FrontEndServer_WebServer(generatedKeys.getInt(1),fes_ws.getFes_WS());

                }
            }
            return f;
            
        }
        catch (SQLException e)
        {
            return f;
        }
        finally
        {
            cleanup(generatedKeys,insertStatement, connection);
        }
    }

   

}
