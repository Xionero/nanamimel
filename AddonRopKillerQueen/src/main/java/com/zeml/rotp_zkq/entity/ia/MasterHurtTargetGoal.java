package com.zeml.rotp_zkq.entity.ia;

import com.zeml.rotp_zkq.entity.stand.SheerHeart;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.util.DamageSource;

import java.util.EnumSet;

public class MasterHurtTargetGoal extends TargetGoal {
    private final SheerHeart sheerHeart;
    private LivingEntity attacked;
    private int timestamp;

    public MasterHurtTargetGoal(SheerHeart sheerHeart) {
        super(sheerHeart, false);
        this.sheerHeart = sheerHeart;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        LivingEntity owner = sheerHeart.getOwner();
        if(owner==null){
            return false;
        }else
        {
            this.attacked = owner.getLastHurtMob();
            int i = owner.getLastHurtMobTimestamp();
            DamageSource attackedBy = attacked != null ? attacked.getLastDamageSource() : null;
            return i != timestamp && !(attackedBy != null && !attackedBy.getMsgId().startsWith("bloodDrain")) &&
                    canAttack(attacked, EntityPredicate.DEFAULT) && sheerHeart.wantsToAttack(attacked, owner);
        }

    }

    @Override
    public void start() {
        mob.setTarget(attacked);
        LivingEntity owner = sheerHeart.getOwner();
        if (owner != null) {
            timestamp = owner.getLastHurtMobTimestamp();
        }
        super.start();
    }
}
