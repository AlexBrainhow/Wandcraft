package com.apertoria.wandcraft.api.aspects;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.lang.reflect.Method;

public class AspectSourceHelper {
    static Method drainEssentia;
    static Method finfEssentia;

    public static boolean drainEssentia(BlockEntity tile, Aspect aspect, Direction direction, int range) {
        try {
            if (drainEssentia == null) {
                Class fake = Class.forName("wandcraft.common.lib.events.EssentiaHandler");
                drainEssentia = fake.getMethod("drainEsentia", BlockEntity.class, Aspect.class, Direction.class, Integer.TYPE);
            }
            return (Boolean)drainEssentia.invoke((Object)null, tile, aspect, direction, range);
        } catch (Exception var) {
            LogUtils.getLogger().warn("[Wandcraft API] Could not invoke 'wandcraft.common.lib.events.EssentiaHandler' method 'drainEssentia'", new Object[0]);
            return false;
        }
    }

    public static boolean findEssentia(BlockEntity tile, Aspect aspect, Direction direction, int range) {
        try {
            if (finfEssentia == null) {
                Class fake = Class.forName("wandcraft.common.lib.events.EssentiaHandler");
                finfEssentia = fake.getMethod("findEssentia", BlockEntity.class, Aspect.class, Direction.class, Integer.TYPE);
            }
            return (Boolean)finfEssentia.invoke((Object)null, tile, aspect, direction, range);
        } catch (Exception var) {
            LogUtils.getLogger().warn("[Wandcraft API] Could not invoke 'wandcraft.common.lib.events.EssentiaHandler' method 'findEssentia'", new Object[0]);
            return false;
        }
    }
}
