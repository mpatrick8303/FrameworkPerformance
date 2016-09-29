package org.ssa.ironyard.model;

public class Classifications implements DomainObject
{

    int id;
    String classification;
    
    
    public Classifications(int id, String classification)
    {
        this.id = id;
        this.classification = classification;
    }


    public Classifications(String classification)
    {
        this.classification = classification;
    }

    public Classifications(){}

    public int getId()
    {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
    }


    public String getClassification()
    {
        return classification;
    }


    public void setClassification(String classification)
    {
        this.classification = classification;
    }


     


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((classification == null) ? 0 : classification.hashCode());
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
        Classifications other = (Classifications) obj;
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
        Classifications other = (Classifications) obj;
        if (classification == null)
        {
            if (other.classification != null)
                return false;
        }
        else if (!classification.equals(other.classification))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
    
    
}
