package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import uk.co.breaktek.asosdemo.data.CategoryTestModelConstants;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryProductListingsEntityTest {
    private Gson mGson;

    @Before
    public void setUp() {
        mGson = new Gson();
    }

    //Quick exploratory test to make sure GSON mappings are working for the category entity models
    @Test
    public void testCategoriesEnityParsing() {
        CategoryProductListingsEntity actual = mGson.fromJson(CategoryTestModelConstants.categoryProductListingsTestJson(), CategoryProductListingsEntity.class);
        System.out.print(actual.toString());
    }
}
