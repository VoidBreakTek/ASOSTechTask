package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import uk.co.breaktek.asosdemo.data.BuildConfig;
import uk.co.breaktek.asosdemo.data.CategoryTestModelConstants;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CategoryEntityTest {
    //Quick exploratory test to make sure GSON mappings are working for the category entity models
    @Test
    public void testCategoriesEnityParsing() {
        Gson gson = new Gson();

        CategoriesEntity actual = gson.fromJson(CategoryTestModelConstants.categoryTestJson(), CategoriesEntity.class);
        CategoriesEntity expected = CategoryTestModelConstants.categoriesEntity1();

        assertThat(expected, equalTo(actual));
    }
}