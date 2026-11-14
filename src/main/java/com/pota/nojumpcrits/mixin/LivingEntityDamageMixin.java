package com.pota.nojumpcrits.mixin;

import com.pota.nojumpcrits.CritFeedbackGate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityDamageMixin {
    @Inject(method = "damage", at = @At("RETURN"), require = 1)
    private void pota$finishCritFeedback(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        CritFeedbackGate.finish((LivingEntity) (Object) this, source, cir.getReturnValueZ());
    }
}
