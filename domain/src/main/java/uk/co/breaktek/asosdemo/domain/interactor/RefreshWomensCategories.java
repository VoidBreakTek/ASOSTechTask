package uk.co.breaktek.asosdemo.domain.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class RefreshWomensCategories extends Interactor {
    private final uk.co.breaktek.asosdemo.domain.repository.CategoryRepository mRepository;

    @Inject
    public RefreshWomensCategories(@Named("SubscribeOn") Scheduler subscribeOn,
                                   @Named("ObserveOn") Scheduler observeOn,
                                   uk.co.breaktek.asosdemo.domain.repository.CategoryRepository repository) {
        super(subscribeOn, observeOn);
        this.mRepository = repository;
    }

    @Override
    protected Observable buildInteractorObservable(InteractorParams params) {
        return this.mRepository.refreshWomensCategories();
    }
}