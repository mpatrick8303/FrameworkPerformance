package org.ssa.ironyard.model;

public class App_OS implements DomainObject
{
    int id;
    String app_OS;
    
    public App_OS(int id, String app_OS)
    {
        this.id = id;
        this.app_OS = app_OS;
    }

    public App_OS(String app_OS)
    {
        this.app_OS = app_OS;
    }
    
    public App_OS(){}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getApp_OS()
    {
        return app_OS;
    }

    public void setApp_OS(String app_OS)
    {
        this.app_OS = app_OS;
    }

    


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((app_OS == null) ? 0 : app_OS.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        App_OS other = (App_OS) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public boolean deeplyEquals(DomainObject obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        App_OS other = (App_OS) obj;
        if (app_OS == null)
        {
            if (other.app_OS != null)
                return false;
        }
        else if (!app_OS.equals(other.app_OS))
            return false;
        if (id != other.id)
            return false;
        return true;
    };
    
    
}
