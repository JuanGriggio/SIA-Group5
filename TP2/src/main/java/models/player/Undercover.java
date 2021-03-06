package models.player;

import models.equipment.*;

import java.util.Map;

public class Undercover extends Player {
    private static final double OPTIMAL_HEIGHT = 1.896;

    public Undercover(Map<Class<? extends Equipment>, Equipment> equipments) {
        super(OPTIMAL_HEIGHT, equipments);
    }

    public Undercover(double height, Map<Class<? extends Equipment>, Equipment> equipments) {
        super(height, equipments);
    }

    public Undercover(double height, Boots boots, Gloves gloves, Helmet helmet, Vest vest, Weapon weapon) {
        super(height, boots, gloves, helmet, vest, weapon);
    }

    @Override
    protected double calculateFitness() {
        return 0.8 * this.attackPoints() + 0.3 * this.defensePoints();
    }

    @Override
    public double getOptimalHeight() {
        return 1.896;
    }

    @Override
    public Class<Undercover> getPlayerType() {
        return Undercover.class;
    }
}
