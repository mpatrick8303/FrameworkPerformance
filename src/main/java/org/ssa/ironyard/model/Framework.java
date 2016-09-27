package org.ssa.ironyard.model;

public class Framework implements DomainObject
{
    Integer id;
    String framework;
    int concurrency8;
    int concurrency16;
    int concurrency32;
    int concurrency64;
    int concurrency128;
    int concurrency256;
    Languages language;
    FrontEndServer_WebServer fes_ws;
    int errors;
    
    
    
    
    public Framework(Integer id, String framework, int concurrency8, int concurrency16, int concurrency32, int concurrency64, int concurrency128, int concurrency256,
            Languages language, FrontEndServer_WebServer fes_ws, int errors)
    {
        this.id = id;
        this.framework = framework;
        this.concurrency8 = concurrency8;
        this.concurrency16 = concurrency16;
        this.concurrency32 = concurrency32;
        this.concurrency64 = concurrency64;
        this.concurrency128 = concurrency128;
        this.concurrency256 = concurrency256;
        this.language = language;
        this.fes_ws = fes_ws;
        this.errors = errors;
    }
    
    

    public Framework(String framework, int concurrency8, int concurrency16, int concurrency32, int concurrency64, int concurrency128, int concurrency256,
            Languages language, FrontEndServer_WebServer fes_ws, int errors)
    {
        this.framework = framework;
        this.concurrency8 = concurrency8;
        this.concurrency16 = concurrency16;
        this.concurrency32 = concurrency32;
        this.concurrency64 = concurrency64;
        this.concurrency128 = concurrency128;
        this.concurrency256 = concurrency256;
        this.language = language;
        this.fes_ws = fes_ws;
        this.errors = errors;
    }



    public Framework(){}


    public Integer getId()
    {
        return id;
    }



    public void setId(Integer id)
    {
        this.id = id;
    }



    public String getFramework()
    {
        return framework;
    }



    public void setFramework(String framework)
    {
        this.framework = framework;
    }



    public int getConcurrency8()
    {
        return concurrency8;
    }



    public void setConcurrency8(int concurrency8)
    {
        this.concurrency8 = concurrency8;
    }



    public int getConcurrency16()
    {
        return concurrency16;
    }



    public void setConcurrency16(int concurrency16)
    {
        this.concurrency16 = concurrency16;
    }



    public int getConcurrency32()
    {
        return concurrency32;
    }



    public void setConcurrency32(int concurrency32)
    {
        this.concurrency32 = concurrency32;
    }



    public int getConcurrency64()
    {
        return concurrency64;
    }



    public void setConcurrency64(int concurrency64)
    {
        this.concurrency64 = concurrency64;
    }



    public int getConcurrency128()
    {
        return concurrency128;
    }



    public void setConcurrency128(int concurrency128)
    {
        this.concurrency128 = concurrency128;
    }



    public int getConcurrency256()
    {
        return concurrency256;
    }



    public void setConcurrency256(int concurrency256)
    {
        this.concurrency256 = concurrency256;
    }


    public Languages getLanguage()
    {
        return language;
    }



    public void setLanguage(Languages language)
    {
        this.language = language;
    }



    public FrontEndServer_WebServer getFes_ws()
    {
        return fes_ws;
    }



    public void setFes_ws(FrontEndServer_WebServer fes_ws)
    {
        this.fes_ws = fes_ws;
    }



  


    public int getErrors()
    {
        return errors;
    }



    public void setErrors(int errors)
    {
        this.errors = errors;
    }



    
    



    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + concurrency128;
        result = prime * result + concurrency16;
        result = prime * result + concurrency256;
        result = prime * result + concurrency32;
        result = prime * result + concurrency64;
        result = prime * result + concurrency8;
        result = prime * result + errors;
        result = prime * result + ((fes_ws == null) ? 0 : fes_ws.hashCode());
        result = prime * result + ((framework == null) ? 0 : framework.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
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
        Framework other = (Framework) obj;
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
        Framework other = (Framework) obj;
        if (concurrency128 != other.concurrency128)
            return false;
        if (concurrency16 != other.concurrency16)
            return false;
        if (concurrency256 != other.concurrency256)
            return false;
        if (concurrency32 != other.concurrency32)
            return false;
        if (concurrency64 != other.concurrency64)
            return false;
        if (concurrency8 != other.concurrency8)
            return false;
        if (errors != other.errors)
            return false;
        if (fes_ws == null)
        {
            if (other.fes_ws != null)
                return false;
        }
        else if (!fes_ws.equals(other.fes_ws))
            return false;
        if (framework == null)
        {
            if (other.framework != null)
                return false;
        }
        else if (!framework.equals(other.framework))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
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
