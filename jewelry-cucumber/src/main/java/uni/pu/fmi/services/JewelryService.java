package uni.pu.fmi.services;

import uni.pu.fmi.models.Category;
import uni.pu.fmi.models.Jewelry;
import uni.pu.fmi.repo.DBMainRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JewelryService {

    public List<Jewelry> load(String categoryName, String jewelryName) {
        List<Jewelry> jewelryList = DBMainRepo.getJewelryList();
        List<Jewelry> result = new ArrayList<>();
        result = filterByCategory(categoryName, result, jewelryList);
        result = filterByJewelryName(jewelryName, result);
        return result;
    }

    private static List<Jewelry> filterByJewelryName(String jewelryName, List<Jewelry> result) {
        if (jewelryName != null && !jewelryName.trim().isEmpty()) {
            result = result.stream().filter(m -> m.getTitle().contains(jewelryName)).collect(Collectors.toList());
        }
        return result;
    }

    private static List<Jewelry> filterByCategory(String categoryName, List<Jewelry> result, List<Jewelry> jewelryList) {
        if (categoryName == null || categoryName.trim().isEmpty()) {
            result = jewelryList;
        } else {
            for (Jewelry jewelry : jewelryList) {
                for (Category category : jewelry.getCategories()) {
                    if (category.getTitle().equals(categoryName)) {
                        result.add(jewelry);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
