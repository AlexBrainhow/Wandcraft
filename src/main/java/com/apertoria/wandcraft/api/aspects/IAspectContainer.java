package com.apertoria.wandcraft.api.aspects;

public interface IAspectContainer {
    AspectList getAspects();
    void setAspect(AspectList aspects);
    boolean doesContainerAccept(Aspect aspect);
    int addToContainer(Aspect aspect, int amount);
    boolean takeFromContainer(Aspect aspect, int amount);
    /** @deprecated */
    @Deprecated
    boolean takeFromContainer(AspectList aspects);
    boolean doesContainerContainAmount(Aspect aspect, int amount);
    /** @deprecated */
    @Deprecated
    boolean doesContainerContainAmount(AspectList aspects);
    int containerContains(Aspect aspect);
}
