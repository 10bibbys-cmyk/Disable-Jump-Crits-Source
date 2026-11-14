package com.pota.nojumpcrits;

import dev.shadowsoffire.attributeslib.packet.CritParticleMessage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayDeque;
import java.util.Iterator;

public final class CritFeedbackGate {
    private static final ThreadLocal<ArrayDeque<PendingCrit>> PENDING = new ThreadLocal<>();

    private CritFeedbackGate() {
    }

    public static void mark(int targetId, PlayerEntity attacker, LivingEntity target, DamageSource source) {
        if (attacker == null || target == null || source == null) {
            return;
        }

        ArrayDeque<PendingCrit> queue = PENDING.get();
        if (queue == null) {
            queue = new ArrayDeque<>();
            PENDING.set(queue);
        }

        queue.addLast(new PendingCrit(targetId, attacker, target, source));
    }

    public static void finish(LivingEntity target, DamageSource source, boolean accepted) {
        ArrayDeque<PendingCrit> queue = PENDING.get();
        if (queue == null || target == null || source == null) {
            return;
        }

        PendingCrit matched = null;
        Iterator<PendingCrit> iterator = queue.descendingIterator();
        while (iterator.hasNext()) {
            PendingCrit pending = iterator.next();
            if (pending.target == target && pending.source == source) {
                matched = pending;
                iterator.remove();
                break;
            }
        }

        if (queue.isEmpty()) {
            PENDING.remove();
        }

        if (matched != null && accepted) {
            CritParticleMessage.sendTo(matched.targetId, matched.attacker);
        }
    }

    private static final class PendingCrit {
        private final int targetId;
        private final PlayerEntity attacker;
        private final LivingEntity target;
        private final DamageSource source;

        private PendingCrit(int targetId, PlayerEntity attacker, LivingEntity target, DamageSource source) {
            this.targetId = targetId;
            this.attacker = attacker;
            this.target = target;
            this.source = source;
        }
    }
}
