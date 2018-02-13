package com.android.daggersetup.model;

import javax.inject.Inject;

/**
 * This vehicle class need a dependency of Motor so injecting in constructor once module is created
 */
public class Vehicle {

    private Motor motor;

    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int value) {
        motor.accelerate(value);
    }

    public void stop() {
        motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }
}
