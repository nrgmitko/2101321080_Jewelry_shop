package uni.pu.fmi.jewelryview;

import io.cucumber.java.en.Then;
import uni.pu.fmi.models.Jewelry;
import uni.pu.fmi.services.JewelryService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckJewelryList {
    private final JewelryHelperModel helperModel;

    public CheckJewelryList(JewelryHelperModel helperModel) {
        this.helperModel = helperModel;
    }

    @Then("Displays a list of available {int} jewelry items")
    public void checkJewelryList(int expectedJewelryCount) {
        if (null == helperModel.getJewelryList()) {
            JewelryService jewelryService = new JewelryService();
            helperModel.setJewelryList(jewelryService.load(helperModel.getCategory(), helperModel.getJewelryName()));
        }
        assertNotNull(helperModel.getJewelryList());
        assertEquals(expectedJewelryCount, helperModel.getJewelryList().size());
    }
}