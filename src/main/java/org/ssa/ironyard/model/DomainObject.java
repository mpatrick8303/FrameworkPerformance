package org.ssa.ironyard.model;

public interface DomainObject extends Cloneable
{
    boolean deeplyEquals(DomainObject obj);
}
