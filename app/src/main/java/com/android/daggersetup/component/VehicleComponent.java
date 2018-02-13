package com.android.daggersetup.component;

import com.android.daggersetup.model.Vehicle;
import com.android.daggersetup.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The connection between the provider of dependencies,
 @Module, and the classes requesting them through @Inject is made using @Component, which is an interface:
 *
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

}
