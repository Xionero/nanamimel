package com.zeml.rotp_zkq.action.stand;

import com.zeml.rotp_zkq.entity.damaging.projectile.SnowBombEntity;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SnowBomb extends StandEntityAction {

    public SnowBomb(Builder builder) {
        super(builder);
    }

    @Override
public void standPerform(@NotNull World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
    if (!world.isClientSide) {
        LivingEntity user = userPower.getUser();

        SnowBombEntity snowBomb = new SnowBombEntity(user, world, userPower);
        snowBomb.setPos(standEntity.getX(), standEntity.getY() + 0.7, standEntity.getZ());
        snowBomb.shootFromRotation(user, 1.5F, standEntity.getProjectileInaccuracy(1.0F));
        standEntity.addProjectile(snowBomb);
        standEntity.playSound(SoundEvents.SNOWBALL_THROW, 1.0F, 1.0F);
    }
}
}
