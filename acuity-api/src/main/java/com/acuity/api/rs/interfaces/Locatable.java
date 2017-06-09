package com.acuity.api.rs.interfaces;

import com.acuity.api.AcuityInstance;
import com.acuity.api.rs.movement.SceneTile;
import com.acuity.api.rs.movement.Tile;
import com.acuity.api.rs.utils.LocalPlayer;

/**
 * Created by Eclipseop.
 * Date: 6/8/2017.
 */
public interface Locatable {

    default int getSceneX() {
        System.out.println("Locatable: returning default sceneX: " + this.getClass().getName());
        return 0;
    }

    default int getSceneY() {
        System.out.println("Locatable: returning default sceneY: " + this.getClass().getName());
        return 0;
    }

    default int getPlane() {
        return AcuityInstance.getClient().getPlane();
    }

    default int getX() {
        return toLocation().getX();
    }

    default int getY() {
        return toLocation().getY();
    }

    default Tile toLocation() {
        return new Tile(getSceneX() + AcuityInstance.getClient().getBaseSceneX(), getSceneY() + AcuityInstance.getClient().getBaseSceneY(), getPlane());
    }

    default SceneTile toSceneTile() {
        return new SceneTile(getSceneX(), getSceneY(), getPlane());
    }

    default int distance() {
        return distance(LocalPlayer.getLocation());
    }

    default boolean isOnMiniMap() {
        return toLocation().isOnMiniMap();
    }

    default int distance(Locatable locatable) {
        return (int) Math.round(distancePrecise(locatable));
    }

    default double distancePrecise() {
        return distancePrecise(LocalPlayer.getLocation());
    }

    default double distancePrecise(Locatable locatable) {
        if (locatable == null) {
            return Integer.MAX_VALUE - 1;
        }

        Tile t = locatable.toLocation();
        Tile t2 = toLocation();

        if (this.getPlane() != this.getPlane()) {
            return Integer.MAX_VALUE - 1;
        }

        return Math.hypot(t.getX() - t2.getX(), t.getY() - t2.getY());
    }
}
