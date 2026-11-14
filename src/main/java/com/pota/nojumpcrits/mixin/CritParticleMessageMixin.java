package com.pota.nojumpcrits.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "dev.shadowsoffire.attributeslib.packet.CritParticleMessage", priority = 1100, remap = false)
public abstract class CritParticleMessageMixin {
   @Inject(method = "apothCrit(I)V", at = @At("TAIL"), require = 1, remap = false)
   private static void pota$addCritFeedback(int var0, CallbackInfo var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2 != null && var2.world != null) {
         Entity var3 = var2.world.getEntityById(var0);
         if (var3 != null) {
            if (var2.player != null) {
               var2.player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, 0.55F, 1.05F);
            }

            if (var2.particleManager != null) {
               double var4 = var3.getX();
               double var6 = var3.getY() + var3.getHeight() * 0.6;
               double var8 = var3.getZ();
               DefaultParticleType var10 = ParticleTypes.ELECTRIC_SPARK;
               var2.particleManager.addParticle(var10, var4 + 0.22, var6 + 0.08, var8, 0.055, 0.08, 0.0);
               var2.particleManager.addParticle(var10, var4 - 0.22, var6 + 0.03, var8, -0.055, 0.075, 0.0);
               var2.particleManager.addParticle(var10, var4, var6 + 0.13, var8 + 0.22, 0.0, 0.085, 0.055);
               var2.particleManager.addParticle(var10, var4, var6 - 0.02, var8 - 0.22, 0.0, 0.07, -0.055);
            }
         }
      }
   }
}
