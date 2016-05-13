package uk.co.breaktek.asosdemo.data;

import java.util.ArrayList;
import java.util.List;

import uk.co.breaktek.asosdemo.domain.enums.CategorySortType;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryListing;
import uk.co.breaktek.asosdemo.data.model.CategoryListingEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryListings;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryTestModelConstants {
    public static String description = "DESCRIPTION";
    public static String categoryId = "CATEGORYID";
    public static String name = "NAME";
    public static int productCount = 101;
    public static String sortType = "AlphaAscending";
    public static CategorySortType sortTypeEnum = CategorySortType.ALPHA_ASCENDING;

    public static String categoryTestJson() {
        return "{\"Description\":\"" + description + "\",\"Listing\":[{\"CategoryId\":\"" + categoryId + "\",\"Name\":\"" + name + "\",\"ProductCount\":" + productCount + "}],\"SortType\":\"" + sortType + "\"}";
    }

    public static String categoryProductListingsTestJson(){
        return "{\"AlsoSearched\":[],\"Description\":\"New In: Clothing\",\"Facets\":[{\"FacetValues\":[{\"Count\":33,\"Id\":\"floor_1000\",\"Name\":\"WOMEN\"}],\"Id\":\"floor\",\"Name\":\"Floor\",\"Sequence\":0},{\"FacetValues\":[{\"Count\":2,\"Id\":\"base_colour_25\",\"Name\":\"Beige\"},{\"Count\":9,\"Id\":\"base_colour_4\",\"Name\":\"Black\"},{\"Count\":9,\"Id\":\"base_colour_3\",\"Name\":\"Blue\"},{\"Count\":1,\"Id\":\"base_colour_10\",\"Name\":\"Brown\"},{\"Count\":5,\"Id\":\"base_colour_20\",\"Name\":\"Cream\"},{\"Count\":1,\"Id\":\"base_colour_11\",\"Name\":\"Gold\"},{\"Count\":1,\"Id\":\"base_colour_2\",\"Name\":\"Green\"},{\"Count\":2,\"Id\":\"base_colour_17\",\"Name\":\"Multi\"},{\"Count\":1,\"Id\":\"base_colour_33\",\"Name\":\"Navy\"},{\"Count\":2,\"Id\":\"base_colour_7\",\"Name\":\"Orange\"},{\"Count\":5,\"Id\":\"base_colour_9\",\"Name\":\"Pink\"},{\"Count\":1,\"Id\":\"base_colour_8\",\"Name\":\"Purple\"},{\"Count\":6,\"Id\":\"base_colour_1\",\"Name\":\"Red\"},{\"Count\":1,\"Id\":\"base_colour_6\",\"Name\":\"Yellow\"}],\"Id\":\"base_colour\",\"Name\":\"Base Colour\",\"Sequence\":0},{\"FacetValues\":[{\"Count\":4,\"Id\":\"attributeitem_1465\",\"Name\":\"Dresses\"},{\"Count\":3,\"Id\":\"attributeitem_1497\",\"Name\":\"Jeans\"},{\"Count\":2,\"Id\":\"attributeitem_1631\",\"Name\":\"Jumpers\"},{\"Count\":3,\"Id\":\"attributeitem_1506\",\"Name\":\"Leggings\"},{\"Count\":3,\"Id\":\"attributeitem_2120\",\"Name\":\"Shirts & blouses\"},{\"Count\":7,\"Id\":\"attributeitem_1573\",\"Name\":\"Skirts\"},{\"Count\":7,\"Id\":\"attributeitem_1604\",\"Name\":\"Tops\"},{\"Count\":3,\"Id\":\"attributeitem_1612\",\"Name\":\"Trousers\"}],\"Id\":\"attribute_900\",\"Name\":\"PRODUCT TYPE\",\"Sequence\":0},{\"FacetValues\":[{\"Count\":2,\"Id\":\"brand_12647\",\"Name\":\"A Wear\"},{\"Count\":27,\"Id\":\"brand_53\",\"Name\":\"ASOS\"},{\"Count\":1,\"Id\":\"brand_12885\",\"Name\":\"Paprika\"},{\"Count\":3,\"Id\":\"brand_12983\",\"Name\":\"River Island\"}],\"Id\":\"brand\",\"Name\":\"Brand\",\"Sequence\":0}],\"ItemCount\":33,\"Listings\":[{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1743838,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/8/3/8/3/1743838/creamblack/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Blouse With Tipped Drop Collar\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1755616,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/6/1/6/5/1755616/spectrumblue/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Mini Skirt With Pocket Front Panel\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1760169,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/6/1/0/1760169/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Midi Skirt in Quilted Jersey\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1769219,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/1/2/9/1769219/cream/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Blouse With Heart Trim\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1785774,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/4/7/7/5/1785774/gold/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Metallic Vest\"},{\"BasePrice\":30.0,\"Brand\":\"River Island\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1798955,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/5/5/9/8/1798955/greyandcream/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"River Island Chunky Knit Boxy Jumper With Zip Back\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1815887,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/7/8/8/5/1815887/print/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Leggings in Winter Ikat Print\"},{\"BasePrice\":30.0,\"Brand\":\"A Wear\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1820379,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/7/3/0/1820379/rust/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"A|Wear Belted Full Skirt\"},{\"BasePrice\":30.0,\"Brand\":\"River Island\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1874987,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/7/8/9/4/1874987/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"River Island PU Motorcross Leggings\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1660922,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/2/2/9/0/1660922/navy/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Lace Layered Collar Shell Top\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1702563,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/3/6/5/2/1702563/mink/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Feather Embroidered One Shoulder Top\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1704648,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/8/4/6/4/1704648/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Pencil Skirt In Longer Length\"},{\"BasePrice\":30.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£30.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1704461,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/1/6/4/4/1704461/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS High Waist Pencil Skirt With  Button Detail\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1747930,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/0/3/9/7/1747930/colonial/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Cropped Ottoman Bootflare Trousers\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1747946,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/6/4/9/7/1747946/dazzlingblue/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Panelled Ponti Skinny Trousers\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1759201,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/1/0/2/9/1759201/cream/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Knitted Tank Top\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1759789,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/8/7/9/1759789/blue/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Pleated Midi Skirt with Contrast Waistband\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1765386,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/6/8/3/5/1765386/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Cut Out Dress with Chain Neck\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1770177,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/7/7/1/0/1770177/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Knitted Leggings With Metallic Spot\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1775973,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/3/7/9/5/1775973/neonpink/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Skinny Jeans in Neon Pink\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1810697,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/7/9/6/0/1810697/sangriapink/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Midi Dress with 3/4 Sleeve\"},{\"BasePrice\":35.0,\"Brand\":\"River Island\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1816389,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/8/3/6/1816389/black/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"River Island Seamed PU Trousers\"},{\"BasePrice\":35.0,\"Brand\":\"A Wear\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1821576,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/6/7/5/1/1821576/cream/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"A|Wear Lazer Cut Top\"},{\"BasePrice\":35.0,\"Brand\":\"Paprika\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1835159,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/5/1/5/1835159/navy/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"Paprika Dress With Sequin Cross Front Detail\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1661358,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/8/5/3/1/1661358/blue/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Midi Dress In Soft Chiffon\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1671244,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/4/4/2/1/1671244/hollyhock/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Purple Skinny Jeans\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1671639,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/3/6/1/1671639/mathylblue/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Light Blue Skinny Jeans\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1704661,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/1/6/6/4/1704661/tangoredcream/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS PETITE Exclusive Mini Dress With  Crochet Collar\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1704230,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/0/3/2/4/1704230/blackwhite/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Houndstooth Panelled Pencil Skirt\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":true,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1703264,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/4/6/2/3/1703264/bakedapple/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Top With Beading\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1703489,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/8/4/3/1703489/red/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Fringe Sleeve Mesh Crop\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1702301,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/1/0/3/2/1702301/nude/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Graphic Embroidered Mesh Top\"},{\"BasePrice\":35.0,\"Brand\":\"ASOS\",\"CurrentPrice\":\"£35.00\",\"HasMoreColours\":false,\"IsInSet\":false,\"PreviousPrice\":\"\",\"ProductId\":1703969,\"ProductImageUrl\":[\"http://images.asos.com/inv/media/9/6/9/3/1703969/mustard/image1xl.jpg\"],\"RRP\":\"\",\"Title\":\"ASOS Embroidered Satin Bow Blouse\"}],\"RedirectUrl\":\"\",\"SortType\":\"PriceAscending\"}";
    }

    public static CategoryListingEntity categoryListingEntity1() {
        CategoryListingEntity item = new CategoryListingEntity();
        item.setCategoryId(categoryId);
        item.setCategoryName(name);
        item.setProductCount(productCount);
        return item;
    }

    public static CategoriesEntity categoriesEntity1() {
        List<CategoryListingEntity> listings = new ArrayList();
        listings.add(categoryListingEntity1());

        CategoriesEntity item = new CategoriesEntity();
        item.setDescription(description);
        item.setSortType(sortType);
        item.setCategoryListings(listings);
        return item;
    }

    public static CategoryListing categoryListing1() {
        return new CategoryListing.CategoryListingBuilder()
                .name(name)
                .productCount(productCount)
                .id(categoryId)
                .build();
    }

    public static CategoryListings categoryListings1() {
        CategoryListings listings = new CategoryListings();
        listings.add(categoryListing1());
        return listings;
    }

    public static List<CategoryListing> categoryListingsList1() {
        List<CategoryListing> listings = new ArrayList<>();
        listings.add(categoryListing1());
        return listings;
    }

    public static Categories categories1() {
        List<CategoryListing> listings = new ArrayList();
        listings.add(categoryListing1());
        return new Categories.CategoriesBuilder()
                .description(description)
                .sortType(sortTypeEnum)
                .categoryListings(categoryListings1())
                .build();
    }
}
