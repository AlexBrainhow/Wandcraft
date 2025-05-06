package com.apertoria.wandcraft.api.aspects;

import net.minecraft.core.Direction;

public interface IEssentiaTransport {
    boolean isConnectable(Direction direction);
    boolean canInputFrom(Direction direction);
    boolean canOutputTo(Direction direction);
    void setSuction(Aspect aspect, int value);
    Aspect getSuctionType(Direction direction);
    int getSuctionAmount(Direction direction);
    int takeEssentia(Aspect aspect, int value, Direction direction);
    int addEssentia(Aspect aspect, int value, Direction direction);
    Aspect getEssentiaType(Direction direction);
    int getEssentiaAmount(Direction direction);
    int getMinimumSuction();
    boolean rendererExtendedTube();
}
