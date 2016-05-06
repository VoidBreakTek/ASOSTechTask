package uk.co.breaktek.asosdemo.di.module.global;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.domain.repository.CategoryRepository;
import uk.co.breaktek.asosdemo.data.repository.category.CategoryDataRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class DataRepositoryModule {
    /**
     * Data layer Property repository
     */
    @Provides
    @Singleton
    CategoryRepository categoryRepository(CategoryDataRepository dataRepository) {
        return dataRepository;
    }
}
