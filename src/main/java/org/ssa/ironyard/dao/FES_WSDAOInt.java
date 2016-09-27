package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.FrontEndServer_WebServer;

public interface FES_WSDAOInt
{
    FrontEndServer_WebServer insert(FrontEndServer_WebServer fes_ws);
    boolean delete(int id);
    int deleteAll();
    FrontEndServer_WebServer read(int id);
    FrontEndServer_WebServer eagerRead(int id);
    List<FrontEndServer_WebServer> readAll();
    List<FrontEndServer_WebServer> eagerReadAll();

}
