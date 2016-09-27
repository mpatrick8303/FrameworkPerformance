package org.ssa.ironyard.model;

public class FrontEndServer_WebServer implements DomainObject
{
    Integer id;
    String fes_WS;
    
    public FrontEndServer_WebServer(Integer id, String fes_WS)
    {
        this.id = id;
        this.fes_WS = fes_WS;
    }
    public FrontEndServer_WebServer(String fes_WS)
    {
        this.fes_WS = fes_WS;
    }
    
    public FrontEndServer_WebServer(){}
    
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getFes_WS()
    {
        return fes_WS;
    }
    public void setFes_WS(String fes_WS)
    {
        this.fes_WS = fes_WS;
    }
    
    
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fes_WS == null) ? 0 : fes_WS.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        FrontEndServer_WebServer other = (FrontEndServer_WebServer) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        return true;
    }
    public boolean deeplyEquals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FrontEndServer_WebServer other = (FrontEndServer_WebServer) obj;
        if (fes_WS == null)
        {
            if (other.fes_WS != null)
                return false;
        }
        else if (!fes_WS.equals(other.fes_WS))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
    
   
    
    
}
