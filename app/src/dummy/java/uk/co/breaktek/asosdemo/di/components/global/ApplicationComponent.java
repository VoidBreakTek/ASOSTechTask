package uk.co.breaktek.asosdemo.di.components.global;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.breaktek.asosdemo.data.di.CloudProviderModule;
import uk.co.breaktek.asosdemo.di.component.global.BaseApplicationComponent;
import uk.co.breaktek.asosdemo.di.module.global.ApplicationModule;
import uk.co.breaktek.asosdemo.di.module.global.DataRepositoryModule;
import uk.co.breaktek.asosdemo.di.module.global.InteractorModule;

/**
 * Root application component to be initialized on startup from the base extended Application
 * instance
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
@Component(modules = {ApplicationModule.class, DataRepositoryModule.class, InteractorModule.class, CloudProviderModule.class})
public interface ApplicationComponent extends BaseApplicationComponent {
}
