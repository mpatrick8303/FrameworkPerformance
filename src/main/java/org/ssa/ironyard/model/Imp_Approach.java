package org.ssa.ironyard.model;

public class Imp_Approach implements DomainObject
{
    int id;
    String imp_Approach;
    
    public Imp_Approach(int id, String imp_Approach)
    {
        this.id = id;
        this.imp_Approach = imp_Approach;
    }
    public Imp_Approach(String imp_Approach)
    {
        this.imp_Approach = imp_Approach;
    }
    public Imp_Approach(){}
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getImp_Approach()
    {
        return imp_Approach;
    }
    public void setImp_Approach(String imp_Approach)
    {
        this.imp_Approach = imp_Approach;
    }
    
    
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((imp_Approach == null) ? 0 : imp_Approach.hashCode());
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
        Imp_Approach other = (Imp_Approach) obj;
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
        Imp_Approach other = (Imp_Approach) obj;
        if (id != other.id)
            return false;
        if (imp_Approach == null)
        {
            if (other.imp_Approach != null)
                return false;
        }
        else if (!imp_Approach.equals(other.imp_Approach))
            return false;
        return true;
    }
    
    
}
