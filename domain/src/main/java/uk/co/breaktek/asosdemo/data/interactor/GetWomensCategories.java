package uk.co.breaktek.asosdemo.data.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import uk.co.breaktek.asosdemo.data.repository.CategoryRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class GetWomensCategories extends Interactor {
    private final CategoryRepository mRepository;

    @Inject
    public GetWomensCategories(@Named("SubscribeOn") Scheduler subscribeOn,
                               @Named("ObserveOn") Scheduler observeOn,
                               CategoryRepository repository) {
        super(subscribeOn, observeOn);
        this.mRepository = repository;
    }

    @Override
    protected Observable buildInteractorObservable(InteractorParams params) {
        return this.mRepository.womensCategories();
    }
}
