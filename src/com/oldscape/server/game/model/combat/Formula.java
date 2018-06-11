package com.oldscape.server.game.model.combat;

import com.oldscape.server.game.model.player.Player;

/**
 * Combat Formula Class
 *
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 11, 2015
 */
public class Formula {

    public static double calculateMaxHit(Player player) {
        double damage = 0;
        damage = calculateMaxRangedHit(player);
        return damage;
    }

    public static double calculateMaxRangedHit(Player player) {
        int rangedLevel = 0;
        double styleBonus = 0;
        rangedLevel += styleBonus;
        double rangedStrength = 0;
        double maxHit = (rangedLevel + rangedStrength / 8 + rangedLevel
                * rangedStrength * Math.pow(64, -1) + 14) / 10;
        return (int) Math.floor(maxHit);
    }

    public static double calculateMaxMeleeHit(Player player) {
        double strengthLevel = 0;
        int styleBonus = 0;
        int effectiveStrengthDamage = (int) (strengthLevel + styleBonus);
        double baseDamage = 5 + (effectiveStrengthDamage + 8) * (10 + 64) / 64;
        int maxHit = (int) Math.floor(baseDamage);
        return (int) Math.floor(maxHit / 10);
    }

    public static double getChance(double attack, double defence) {
        double A = Math.floor(attack);
        double D = Math.floor(defence);
        double chance = A < D ? (A - 1.0) / (2.0 * D) : 1.0 - (D + 1.0)
                / (2.0 * A);
        chance = chance > 0.9999 ? 0.9999 : chance < 0.0001 ? 0.0001 : chance;
        return chance;
    }

}
