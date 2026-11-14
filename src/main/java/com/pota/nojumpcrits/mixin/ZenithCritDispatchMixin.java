package com.pota.nojumpcrits.mixin;

import com.pota.nojumpcrits.CritFeedbackGate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = "dev.shadowsoffire.attributeslib.impl.AttributeEvents", priority = 1100, remap = false)
public abstract class ZenithCritDispatchMixin {
    /**
     * Zenith Attributes Renewed 1.0.3 emits its crit packet from this synthetic
     * lambda before LivingEntity#damage has returned. Capture the exact damage
     * invocation so nested/secondary hits cannot consume the wrong feedback.
     */
    @Redirect(
        method = "lambda$apothCriticalStrike$3(Lnet/minecraft/class_1282;Lnet/minecraft/class_1309;F)F",
        at = @At(
            value = "INVOKE",
            target = "Ldev/shadowsoffire/attributeslib/packet/CritParticleMessage;sendTo(ILnet/minecraft/class_1657;)V"
        ),
        require = 1,
        remap = false
    )
    private static void pota$delayCritFeedback(
        int targetId,
        PlayerEntity attacker,
        DamageSource source,
        LivingEntity damaged,
        float amount
    ) {
        CritFeedbackGate.mark(targetId, attacker, damaged, source);
    }
}
