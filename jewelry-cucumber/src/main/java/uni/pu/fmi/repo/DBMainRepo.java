package uni.pu.fmi.repo;

import lombok.Getter;
import uni.pu.fmi.models.Category;
import uni.pu.fmi.models.Jewelry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class DBMainRepo {
    private static  List<Jewelry> jewelryList = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    static {
        Category category1 = new Category(1L, "Rings", "A collection of rings", null, null);
        Category category2 = new Category(2L, "Necklaces", "A collection of necklaces", null, null);
        Category category3 = new Category(3L, "Bracelets", "A collection of bracelets", null, null);

        jewelryList.add(new Jewelry(1L, "Diamond Ring", "A stunning diamond ring", 10, 999.99d, Set.of(category1)));
        jewelryList.add(new Jewelry(2L, "Emerald Ring", "A stunning emerald ring", 10, 999.99d, Set.of(category1)));
        jewelryList.add(new Jewelry(3L, "Silver Ring", "A stunning silver ring", 10, 999.99d, Set.of(category1)));
        jewelryList.add(new Jewelry(4L, "Gold Ring", "A stunning gold ring", 10, 999.99d, Set.of(category1)));
        jewelryList.add(new Jewelry(4L, "Wood Ring", "A stunning wooden ring", 10, 999.99d, Set.of(category1)));
        jewelryList.add(new Jewelry(5L, "Gold Necklace", "An elegant gold necklace", 20, 499.99d, Set.of(category2)));


        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<Jewelry> getJewelryList() {
        return jewelryList;
    }
}