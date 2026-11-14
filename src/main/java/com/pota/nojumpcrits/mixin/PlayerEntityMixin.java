package com.pota.nojumpcrits.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    /**
     * Minecraft 1.20.1 stores the vanilla airborne-critical flag in local slot 8
     * inside PlayerEntity#attack. Keep the hook deliberately version-pinned.
     */
    @ModifyVariable(method = "attack", at = @At("STORE"), index = 8, require = 1)
    private boolean pota$disableVanillaJumpCrit(boolean vanillaCritical) {
        return false;
    }
}
