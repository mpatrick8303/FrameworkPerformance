package org.ssa.ironyard.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.service.FrameworkServices;

@Controller
@RequestMapping(value = "/json")
public class FrameworkController
{
    @Autowired
    FrameworkServices frameService;
    
    public FrameworkController(FrameworkServices fs)
    {
        frameService = fs;
    }
    
    @RequestMapping(value = {"","/"})
    public String home()
    {
        return "index.html";
    }
    
    @RequestMapping(value = "frameworks", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Framework>> getFrameworks()
    {
        List<Framework> frames = frameService.displayFrameworks(); 
        return ResponseEntity.ok().header("JSON Serialization", "Frameworks").body(frames);
    }
}
