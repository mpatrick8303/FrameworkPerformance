package org.ssa.ironyard.model;

public class Languages implements DomainObject
{
    Integer ID;
    String language;
    
    
    public Languages(Integer iD, String language)
    {
        ID = iD;
        this.language = language;
    }


    public Languages(String language)
    {
        this.language = language;
    }
    public Languages(){}
    

    public Integer getID()
    {
        return ID;
    }


    public void setID(int iD)
    {
        ID = iD;
    }


    public String getLanguage()
    {
        return language;
    }


    public void setLanguage(String language)
    {
        this.language = language;
    }


    
    public Object clone()
    {
    
            try
            {
                return super.clone();
            }
            catch (CloneNotSupportedException e)
            {
                return null;
            }
       
    }

  
    


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
        Languages other = (Languages) obj;
        if (ID == null)
        {
            if (other.ID != null)
                return false;
        }
        else if (!ID.equals(other.ID))
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
        Languages other = (Languages) obj;
        if (ID == null)
        {
            if (other.ID != null)
                return false;
        }
        else if (!ID.equals(other.ID))
            return false;
        if (language == null)
        {
            if (other.language != null)
                return false;
        }
        else if (!language.equals(other.language))
            return false;
        return true;
    }


    

    




    
    
    
}
