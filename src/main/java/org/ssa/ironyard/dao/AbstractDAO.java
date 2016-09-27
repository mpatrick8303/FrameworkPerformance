package org.ssa.ironyard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.ssa.ironyard.ORM.ORMInterface;
import org.ssa.ironyard.model.DomainObject;



public abstract class AbstractDAO<T extends DomainObject>
{
    protected final DataSource datasource;
    protected final ORMInterface<T> orm;
    
    protected AbstractDAO(DataSource datasource, ORMInterface<T> orm)
    {
        this.datasource = datasource;
        this.orm = orm;
    }
    
    public abstract T insert(T domain);
    
    public boolean delete(int id)
    {
        PreparedStatement prepareStatement = null;
        Connection connection = null;
        try
        {
            connection = this.datasource.getConnection();
            prepareStatement = connection.prepareStatement(orm.prepareDelete());
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            return false;
        }
        finally {
            cleanup(prepareStatement,connection);
        }
        
           
        
    }
    
    public int deleteAll()
    {
        Statement clear = null;
        Connection connection = null;
        try
        {
            connection = this.datasource.getConnection();
            clear = connection.createStatement();
            System.out.println(this.orm.table());
            return clear.executeUpdate("DELETE FROM " + this.orm.table() + ";");
        }
        catch (SQLException e)
        {
            return 0;
        }
        finally {
            cleanup(clear,connection);
        }
    }
    
    public T read(int id)
    {
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
        T t = null;
        
        try
        {
            connection = this.datasource.getConnection();
            read = connection.prepareStatement(this.orm.prepareRead());
            read.setInt(1, id);
            query = read.executeQuery();
            
            if(query.next())
                return t = this.orm.map(query);
            else
                return t;
        }
        catch(SQLException ex)
        {
            return t;
        }
        finally {
            cleanup(query,read,connection);
        }
    }
    
    public T eagerRead(int id)
    {
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
        T t = null;
        
        try
        {
            connection = this.datasource.getConnection();
            read = connection.prepareStatement(this.orm.pepareEagerRead());
            read.setInt(1, id);
            query = read.executeQuery();
            
            if(query.next())
                return t = this.orm.eagerMap(query);
            else
                return t;
        }
        catch(SQLException ex)
        {
            return t;
        }
        finally {
            cleanup(query,read,connection);
        }
    }
    
    public List<T> readAll()
    {
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
        
        
        List<T> resultList = new ArrayList();
                
        
        try
        {
            connection = this.datasource.getConnection();
            read = connection.prepareStatement(this.orm.prepareReadAll());
            query = read.executeQuery();
            
            while(query.next())
            {
                T t = orm.map(query);
                resultList.add(t);
            }
            
            if(query.next())
             return resultList;
            else
                return resultList;
           
        }
        catch(SQLException ex)
        {
            return resultList;
        }
        finally {
            cleanup(query,read,connection);
        }
    }
    
    public List<T> eagerReadAll()
    {
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
        
        List<T> resultList = new ArrayList();
                
        
        try
        {
            connection = this.datasource.getConnection();
            read = connection.prepareStatement(this.orm.pepareEagerReadAll());
            query = read.executeQuery();
            
            while(query.next())
            {
                T t = orm.eagerMap(query);
                resultList.add(t);
            }
            
            if(query.next())
             return resultList;
            else
                return resultList;
           
        }
        catch(SQLException ex)
        {
            return resultList;
        }
        finally {
            cleanup(query,read,connection);
        }
    }
    
    static protected void cleanup(ResultSet results, Statement statement, Connection connection)
    {
       try
       {
           if(results != null)
               results.close();
           
       }
       catch(SQLException e)
       {
           throw new RuntimeException();
       }
       cleanup(statement, connection);

    }

    static protected void cleanup(Statement statement, Connection connection)
    {
        try
        {
            if(statement != null)
                statement.close();
          
        }
        catch(SQLException e)
        {
            throw new RuntimeException();
        }
    }
    
    static protected void cleanup(Connection connection)
    {
        try
        {
            if(connection != null)
                connection.close();
        }
        catch(SQLException e)
        {
            throw new RuntimeException();
        }
    }
}
