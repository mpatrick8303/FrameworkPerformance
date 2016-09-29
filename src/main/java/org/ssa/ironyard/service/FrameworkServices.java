package org.ssa.ironyard.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssa.ironyard.dao.FES_WSDAO;
import org.ssa.ironyard.dao.FrameworkDAO;
import org.ssa.ironyard.dao.LanguagesDAO;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.model.FrontEndServer_WebServer;
import org.ssa.ironyard.model.Languages;



@Component
public class FrameworkServices implements FrameworkServicesInt
{
    
    FrameworkDAO frame;
    LanguagesDAO lan;
    FES_WSDAO fes;
    
    
    @Autowired
    public FrameworkServices(FrameworkDAO frame,LanguagesDAO lan, FES_WSDAO fes)
    {
        this.frame = frame;
        this.lan = lan;
        this.fes = fes;
    }

    @Override
    public void setupDatabase()
    {
        List<String[]> readList = new ArrayList<String[]>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/admin/workspace/FrameworkPerformance/src/main/Resources/benchmarks.csv"));
            String str;
           
            
            while ((str = in.readLine()) != null) {
                readList.add(str.split(",")); 
            }
            
            in.close();
            
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        Languages rL = null;
        FrontEndServer_WebServer fL = null;
        
        List<Languages> readLList;
        List<FrontEndServer_WebServer> readFList;
        
        Set<Languages> langSet = new HashSet<>();
        Set<FrontEndServer_WebServer> fesSet = new HashSet<>();
        
        
        
        List<Framework> listFrame = new ArrayList<>();
        
        
        for (int i = 0; i < readList.size(); i++)
        {
            langSet.add(new Languages(readList.get(i)[1]));
            fesSet.add(new FrontEndServer_WebServer(readList.get(i)[2]));
        }
        
        readLList = new ArrayList<Languages>(langSet);
        readFList = new ArrayList<FrontEndServer_WebServer>(fesSet);

        for (int i = 0; i < readLList.size(); i++)
        {
            Languages l = readLList.get(i);
            Languages a = lan.insert(l);
            
        }
        for (int i = 0; i < readFList.size(); i++)
        {
            FrontEndServer_WebServer f = readFList.get(i);
            fes.insert(f);
            
        }
        
        List<Languages> langs = lan.readAll();
        List<FrontEndServer_WebServer> fesw = fes.readAll();
        

        for (int i = 0; i < readList.size(); i++)
        {
            for (int j = 0; j < langs.size(); j++)
            {
                if(readList.get(i)[1].equals(langs.get(j).getLanguage()))
                {
                    rL = langs.get(j);
                    break;
                }
                    
                
            }
            for (int v = 0; v < fesw.size(); v++)
            {
                if(readList.get(i)[2].equals(fesw.get(v).getFes_WS()))
                {
                    fL = fesw.get(v);
                    break;
                }
                    
                
            }

            Framework f = new Framework(readList.get(i)[0],Integer.parseInt(readList.get(i)[3]),Integer.parseInt(readList.get(i)[4]),Integer.parseInt(readList.get(i)[5]),Integer.parseInt(readList.get(i)[6]),Integer.parseInt(readList.get(i)[7]),Integer.parseInt(readList.get(i)[8]),rL,fL,Integer.parseInt(readList.get(i)[9]));
            frame.insert(f);
        }

    }


    @Override
    public Framework insertFramework(Framework framework)
    {
        return frame.insert(framework);
        
    }

    @Override
    public List<Framework> displayFrameworks()
    {
        return frame.eagerReadAll();
    }
    
    
    @Override
    public Framework displayFramework(int id)
    {
        return frame.eagerRead(id);
    }



   

}
