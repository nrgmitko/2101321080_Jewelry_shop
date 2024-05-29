package uni.pu.fmi.jewelryview;


import io.cucumber.java.en.When;


public class SelectStarsStep
{
    private final Stars stars;
    public SelectStarsStep(Stars stars){
        this.stars=stars;
    }


    @When("избира {int} звезда")
    public void selectStar(Integer rating) {
        stars.setRating(rating);
    }
}


