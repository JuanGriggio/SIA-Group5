package models.player;

import models.equipment.*;

import java.util.Map;

public class Defender extends Player {
    public Defender(double height) {
        super(height);
    }

    public Defender(double height, Map<Class<? extends Equipment>, Equipment> equipments) {
        super(height, equipments);
    }

    @Override
    public double fitness() {
        return 0.3 * this.attackPoints() + 0.8 * this.defensePoints();
    }

    @Override
    public Class<Defender> getPlayerType() {
        return Defender.class;
    }
}