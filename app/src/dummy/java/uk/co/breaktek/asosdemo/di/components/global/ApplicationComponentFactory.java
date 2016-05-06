package uk.co.breaktek.asosdemo.di.components.global;

import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.data.di.CloudProviderModule;
import uk.co.breaktek.asosdemo.data.di.LocalDataProviderModule;
import uk.co.breaktek.asosdemo.di.module.global.ApplicationModule;
import uk.co.breaktek.asosdemo.di.module.global.DataRepositoryModule;
import uk.co.breaktek.asosdemo.di.module.global.InteractorModule;

/**
 * Factory class for creating ApplicationComponent instances. If multiple build flavors are used
 * this class can be swapped out in multiple source trees to provide the correct base Application
 * Component with the appropriate modules for that flavor.
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ApplicationComponentFactory {
    public static ApplicationComponent create(ASOSDemoApplication application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .cloudProviderModule(new CloudProviderModule(application))
                .localDataProviderModule(new LocalDataProviderModule(application))
                .interactorModule(new InteractorModule())
                .dataRepositoryModule(new DataRepositoryModule())
                .build();
    }
}