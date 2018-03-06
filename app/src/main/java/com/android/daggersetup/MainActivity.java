package com.android.daggersetup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.daggersetup.component.DaggerVehicleComponent;
import com.android.daggersetup.component.VehicleComponent;
import com.android.daggersetup.model.Vehicle;
import com.android.daggersetup.module.VehicleModule;

/**
 *
 * To implement Dagger 2 correctly, you have to follow these steps:

 1. Identify the dependent objects and its dependencies.
 2. Create a class with the @Module annotation, using the @Provides annotation for every method that returns a dependency.
 3. Request dependencies in your dependent objects using the @Inject annotation.
 4. Create an interface using the @Component annotation and add the classes with the @Module annotation created in the second step.
 5. Create an object of the @Component interface to instantiate the dependent object with its dependencies.
 *
 */

public class MainActivity extends AppCompatActivity {

    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call the interface to get the dependencies of that component and make sure that component has those modules
        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        vehicle = component.provideVehicle();

        Toast.makeText(this, "Vehicle Speed....: " + vehicle.getSpeed(), Toast.LENGTH_SHORT).show();
    }
}
