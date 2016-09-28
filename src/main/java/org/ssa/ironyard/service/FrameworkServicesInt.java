package org.ssa.ironyard.service;

import java.util.List;

import org.ssa.ironyard.model.Framework;

public interface FrameworkServicesInt
{
    void setupDatabase();
    Framework insertFramework(Framework framework);
    List<Framework> displayFrameworks();
    Framework displayFramework(int id);
}
