package uk.co.breaktek.asosdemo.data.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Collection;

import uk.co.breaktek.asosdemo.data.BuildConfig;
import uk.co.breaktek.asosdemo.data.CategoryTestModelConstants;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.data.model.CategoryListingEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoriesEntityMapperTest {

    @Test
    public void testCategoriesMapping() {
        CategoryListingEntityMapper mockListingMapper = Mockito.mock(CategoryListingEntityMapper.class);
        Mockito.when(mockListingMapper.transform(Mockito.<CategoryListingEntity>any()))
                .thenReturn(CategoryTestModelConstants.categoryListing1());
        Mockito.when(mockListingMapper.transform(Mockito.<Collection<CategoryListingEntity>>any()))
                .thenReturn(CategoryTestModelConstants.categoryListingsList1());

        CategoriesEntityMapper mapper = new CategoriesEntityMapper();
        mapper.mCategoryListingEntityMapper = mockListingMapper;
        Categories expected = CategoryTestModelConstants.categories1();
        CategoriesEntity categoriesEntity = CategoryTestModelConstants.categoriesEntity1();

        Categories actual = mapper.transform(categoriesEntity);

        assertThat(actual, equalTo(expected));
    }
}
