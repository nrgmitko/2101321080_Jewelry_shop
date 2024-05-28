package uni.pu.fmi.services;

import uni.pu.fmi.models.Category;
import uni.pu.fmi.repo.DBMainRepo;

import java.util.List;

public class CategoryService {

    public List<Category> load() {
        return DBMainRepo.getCategories();
    }
}
