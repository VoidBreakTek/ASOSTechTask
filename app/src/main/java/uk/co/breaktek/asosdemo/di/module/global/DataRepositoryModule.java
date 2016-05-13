package uk.co.breaktek.asosdemo.di.module.global;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.data.repository.product.ProductDataRepository;
import uk.co.breaktek.asosdemo.domain.repository.CategoryRepository;
import uk.co.breaktek.asosdemo.data.repository.category.CategoryDataRepository;
import uk.co.breaktek.asosdemo.domain.repository.ProductRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class DataRepositoryModule {
    /**
     * Data layer Category repository
     */
    @Provides
    @Singleton
    CategoryRepository categoryRepository(CategoryDataRepository dataRepository) {
        return dataRepository;
    }

    /**
     * Data layer Product repository
     */
    @Provides
    @Singleton
    ProductRepository productRepository(ProductDataRepository dataRepository) {
        return dataRepository;
    }
}
