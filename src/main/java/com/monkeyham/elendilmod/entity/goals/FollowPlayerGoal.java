package com.monkeyham.elendilmod.entity.goals;

import com.monkeyham.elendilmod.entity.custom.Gondor.HumanAbstract;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class  FollowPlayerGoal<T extends HumanAbstract> extends Goal {

    private final T entity;
    private final Player p1;
    private int tick = 0;

    public FollowPlayerGoal(T entity, Player p1) {
    this.entity = entity;
        this.p1 = p1;
    }

    @Override
    public boolean canUse() {
        return entity.follow;
    }

    @Override
    public void tick() {

//        if(tick>8)
//        {
            tick=0;
            RandomSource random = entity.getRandom();
            Vec3 vec3 = DefaultRandomPos.getPosTowards(this.entity, 5, 7, this.p1.position(), (double)((float)Math.PI / 2F));
            if (vec3!=null) {
                entity.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, .9);
            }
//        }
//        tick++;
    }
}
