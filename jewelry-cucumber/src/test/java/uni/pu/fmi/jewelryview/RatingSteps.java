package uni.pu.fmi.jewelryview;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.RatingService;

import static org.junit.Assert.assertEquals;




public class RatingSteps {
    private String jewelryName;
    private String message;
    private Stars stars;
    private String comment;

    public RatingSteps(Stars stars) {
        this.stars = stars;
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }


    @Given("Потребителя отваря детайлите на {string}")
    public void openJewelryDetails(String jewelryName) {
        this.jewelryName = jewelryName;
    }


    @When("Въвежда коментар {string}")
    public void addComment(String comment) {
        this.comment = comment;
    }

    @When("Натиска бутона оцени")
    public void submitRating() {
        RatingService ratingService = new RatingService();
        message = ratingService.rateJewelry(jewelryName, stars.getRating(), comment);
    }

    @Then("Вижда съобщение {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }
}
