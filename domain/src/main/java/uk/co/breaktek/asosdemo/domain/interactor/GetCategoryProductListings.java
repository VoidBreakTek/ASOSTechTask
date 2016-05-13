package uk.co.breaktek.asosdemo.domain.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import uk.co.breaktek.asosdemo.domain.repository.ProductRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class GetCategoryProductListings extends Interactor<GetCategoryProductListings.Params> {
    private final ProductRepository mRepository;

    @Inject
    public GetCategoryProductListings(@Named("SubscribeOn") Scheduler subscribeOn,
                                      @Named("ObserveOn") Scheduler observeOn,
                                      ProductRepository repository) {
        super(subscribeOn, observeOn);
        this.mRepository = repository;
    }

    @Override
    protected Observable buildInteractorObservable(Params params) {
        return mRepository.categoryProductListings(params.getmCategoryId());
    }

    public static class Params extends InteractorParams {
        private final String mCategoryId;

        public Params(String categoryId) {
            this.mCategoryId = categoryId;
        }

        String getmCategoryId() {
            return this.mCategoryId;
        }
    }
}
