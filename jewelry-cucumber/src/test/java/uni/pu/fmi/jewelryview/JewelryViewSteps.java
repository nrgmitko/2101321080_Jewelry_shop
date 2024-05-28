package uni.pu.fmi.jewelryview;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.models.Category;
import uni.pu.fmi.services.CategoryService;
import uni.pu.fmi.services.JewelryService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JewelryViewSteps {
    private final JewelryHelperModel helperModel;

    public JewelryViewSteps(JewelryHelperModel helperModel) {
        this.helperModel = helperModel;
    }

    @When("отваряне на приложението")
    public void openApp() {
        // Missing real app implementation
    }

    @When("натиска бутона за търсене")
    public void clickSearchButton() {
        JewelryService jewelryService = new JewelryService();
        helperModel.setJewelryList(jewelryService.load(helperModel.getCategory(),
                helperModel.getJewelryName()));
    }


    @Then("Визуализира се списък с категории")
    public void checkCategories() {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.load();
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Rings")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Necklaces")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Bracelets")));
        assertEquals(3, categories.size());
    }

    @When("потребителя избере категория: {string}")
    public void chooseCategory(String category) {
        this.helperModel.setCategory(category);
    }

    @When("потребителя въвежда име на бижутерия {string} в полето за търсене")
    public void addJewelryInSearchField(String jewelryName) {
        this.helperModel.setJewelryName(jewelryName);
    }

    @Then("Визуализира списък с наличните {int} бижута")
    public void visualizeJewelryList(int numberOfJewelryItems ) {
        // Implement the logic to visualize the jewelry list with the specified count
    }


    @When("потребителя въвежда име на бижуто {string} в полето за търсене")
    public void userEntersJewelryNameInSearchField(String jewelryName) {
        // Implement the logic to enter the jewelry name in the search field
    }

}

