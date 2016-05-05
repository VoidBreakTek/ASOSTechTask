package uk.co.breaktek.asosdemo.di.module.global;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.breaktek.asosdemo.data.interactor.GetMensCategories;
import uk.co.breaktek.asosdemo.data.interactor.Interactor;
import uk.co.breaktek.asosdemo.data.repository.CategoryRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class InteractorModule {
    private static final String TAG = InteractorModule.class.getSimpleName();

    /**
     * Subscribe using new io worker thread (Served by io scheduler)
     */
    @Provides
    @Singleton
    @Named("SubscribeOn")
    Scheduler provideSubscribeOnScheduler() {
        //Was using Schedulers.io() but does not seem to use more than one thread
        // return Schedulers.io();
        return Schedulers.newThread();
    }

    /**
     * Observe on UI thread (served by AndroidScheduler/main)
     */
    @Provides
    @Singleton
    @Named("ObserveOn")
    Scheduler provideObserveOnScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Singleton
    @Provides
    @Named("GetMensCategories")
    Interactor getMensCategories(@Named("SubscribeOn") Scheduler subscribeOnScheduler,
                                 @Named("ObserveOn") Scheduler observeOnScheduler,
                                 CategoryRepository repository) {
        return new GetMensCategories(subscribeOnScheduler, observeOnScheduler, repository);
    }

    @Singleton
    @Provides
    @Named("GetWomensCategories")
    Interactor getWomensCategories(@Named("SubscribeOn") Scheduler subscribeOnScheduler,
                                   @Named("ObserveOn") Scheduler observeOnScheduler,
                                   CategoryRepository repository) {
        return new GetMensCategories(subscribeOnScheduler, observeOnScheduler, repository);
    }
}
