package uk.co.breaktek.asosdemo.domain.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import uk.co.breaktek.asosdemo.domain.repository.CategoryRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class GetMensCategories extends Interactor {
    private final CategoryRepository mRepository;

    @Inject
    public GetMensCategories(@Named("SubscribeOn") Scheduler subscribeOn,
                             @Named("ObserveOn") Scheduler observeOn,
                             CategoryRepository repository) {
        super(subscribeOn, observeOn);
        this.mRepository = repository;
    }

    @Override
    protected Observable buildInteractorObservable(InteractorParams params) {
        return this.mRepository.mensCategories();
    }
}
