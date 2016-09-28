package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssa.ironyard.ORM.FES_WSORM;
import org.ssa.ironyard.ORM.FrameworkORM;
import org.ssa.ironyard.ORM.LanguageORM;
import org.ssa.ironyard.ORM.ORMInterface;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;

import com.mysql.cj.api.jdbc.Statement;

@Component
public class FrameworkDAO extends AbstractDAO<Framework> implements FrameworkDAOInt
{
    
    
    @Autowired
    public FrameworkDAO(DataSource datasource)
    {
        super(datasource, new FrameworkORM(){});
        
    }

    @Override
    public Framework insert(Framework framework)
    {
        System.out.println(framework.getFramework());
        Framework f = null;
        Framework fUse = framework;
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet generatedKeys = null;
        LanguagesDAO lD = new LanguagesDAO(datasource);
        FES_WSDAO fD = new FES_WSDAO(datasource);
        
        
        
        if(fUse.getLanguage().getID() == null)
        {
            Languages lO = fUse.getLanguage();
            if(!checkLanguage(lO))
            {
                Languages lN = lD.insert(lO);
                
                lO.setID(lN.getID());
                fUse.setLanguage(lO);
               
            }
            else
            {
                List<Languages> lList = lD.readAll();
                for (int i = 0; i < lList.size(); i++)
                {
                    Languages lR = lList.get(i);
                    if(lR.getLanguage().equals(lO.getLanguage()))
                    {
                        fUse.setLanguage(lR);
                    }
                }
            }
            
            
        }
        if(framework.getFes_ws().getId() == null)
        {
            FrontEndServer_WebServer fO = fUse.getFes_ws();
            if(!checkFES(fO))
            {
                FrontEndServer_WebServer fN = fD.insert(fO);
                
                fO.setId(fN.getId());
                fUse.setFes_ws(fO);
              
            }
            else
            {
                List<FrontEndServer_WebServer> fList = fD.readAll();
                for (int i = 0; i < fList.size(); i++)
                {
                    FrontEndServer_WebServer fR = fList.get(i);
                    if(fR.getFes_WS().equals(fO.getFes_WS()))
                    {
                        fUse.setFes_ws(fR);
                    }
                }
            }
           
        }
        
        
        try
        {
            int lang = fUse.getLanguage().getID();
            int fw = fUse.getFes_ws().getId();
            connection = datasource.getConnection();
            insertStatement = connection.prepareStatement(orm.prepareInsert(),Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, fUse.getFramework());
            insertStatement.setInt(2, fUse.getConcurrency8());
            insertStatement.setInt(3, fUse.getConcurrency16());
            insertStatement.setInt(4, fUse.getConcurrency32());
            insertStatement.setInt(5, fUse.getConcurrency64());
            insertStatement.setInt(6, fUse.getConcurrency128());
            insertStatement.setInt(7, fUse.getConcurrency256());
            insertStatement.setInt(8, lang);
            insertStatement.setInt(9, fw);
            insertStatement.setInt(10, fUse.getErrors());
               

                
            if (insertStatement.executeUpdate() > 0)
            {
                generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next())
                {
                    f = new Framework(generatedKeys.getInt(1),fUse.getFramework(),fUse.getConcurrency8(),fUse.getConcurrency16(),
                            fUse.getConcurrency32(),fUse.getConcurrency64(),fUse.getConcurrency128(),fUse.getConcurrency256(),
                            fUse.getLanguage(),fUse.getFes_ws(),fUse.getErrors());


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

        
    

    
    public boolean checkLanguage(Languages l)
    {
        LanguagesDAO lD = new LanguagesDAO(datasource);
        
        List<Languages> languageResults = new ArrayList();
        languageResults = lD.readAll();
        
        System.out.println(languageResults.size());
        
        for (int i = 0; i < languageResults.size(); i++)
        {
            if(languageResults.get(i).getLanguage().equals(l.getLanguage()))
                return true;
            
        }
        return false;
    }
    
    
    public boolean checkFES(FrontEndServer_WebServer f)
    {
        FES_WSDAO fD = new FES_WSDAO(datasource);
        
        List<FrontEndServer_WebServer> fsResults = new ArrayList();
        fsResults = fD.readAll();
        
        for (int i = 0; i < fsResults.size(); i++)
        {
            if(fsResults.get(i).getFes_WS().equals(f.getFes_WS()))
                return true;
            
        }
        return false;
    }

    
  
    
    



   
}
