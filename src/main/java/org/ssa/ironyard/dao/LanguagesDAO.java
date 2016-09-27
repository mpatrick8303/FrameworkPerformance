package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.ssa.ironyard.ORM.LanguageORM;
import org.ssa.ironyard.ORM.ORMInterface;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.api.jdbc.Statement;

public class LanguagesDAO extends AbstractDAO<Languages> implements LanguageDAOInt
{

    protected LanguagesDAO(DataSource datasource)
    {
        super(datasource, new LanguageORM(){});
    }

    @Override
    public Languages insert(Languages language)
    {
        Languages l = null;
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet generatedKeys = null;
        
        try
        {
            connection = datasource.getConnection();
            insertStatement = connection.prepareStatement(orm.prepareInsert(),Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, language.getLanguage());
            
            if(insertStatement.executeUpdate() > 0)
            {
                generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next())
                {
                    l = new Languages(generatedKeys.getInt(1),language.getLanguage());

                }
            }
            return l;
            
        }
        catch (SQLException e)
        {
            return l;
        }
        finally
        {
            cleanup(generatedKeys,insertStatement, connection);
        }
    }

 

}
