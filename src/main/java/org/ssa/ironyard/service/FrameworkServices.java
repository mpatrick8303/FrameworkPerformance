package org.ssa.ironyard.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.ssa.ironyard.dao.FrameworkDAO;
import org.ssa.ironyard.model.Framework;

import com.csvreader.CsvReader;

@Component
public class FrameworkServices implements FrameworkServicesInt
{
    
    FrameworkDAO frame;
    
    

    public FrameworkServices(FrameworkDAO frame)
    {
        this.frame = frame;
    }

    @Override
    public void setupDatabase()
    {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/admin/workspace/FrameworkPerformance/src/main/Resources/benchmarks.csv"));
            String str;
            str = in.readLine();
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }
    
    public void setupDatabase2()
    {
        CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
           // nextLine[] is an array of values from the line
           System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
    }
    
    

    @Override
    public Framework insertFramework(Framework framework)
    {
        return framework;
        
    }



   

}
