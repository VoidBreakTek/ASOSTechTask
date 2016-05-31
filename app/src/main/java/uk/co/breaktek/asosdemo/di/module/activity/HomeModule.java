package uk.co.breaktek.asosdemo.di.module.activity;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.common.annotation.ActivityScope;
import uk.co.breaktek.asosdemo.feature.home.HomeView;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class HomeModule {
    private HomeView mView;

    public HomeModule(HomeView view){
        this.mView = view;
    }

    @Provides
    @ActivityScope
    HomeView view(){
        return mView;
    }
}
