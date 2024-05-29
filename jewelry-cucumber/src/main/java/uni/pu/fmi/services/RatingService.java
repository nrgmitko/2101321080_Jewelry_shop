package uni.pu.fmi.services;

import uni.pu.fmi.repo.DBMainRepo;
import uni.pu.fmi.models.Rating;
import uni.pu.fmi.models.Jewelry;

public class RatingService {

    public String rateJewelry(String jewelryName, Integer rating, String comment) {
        String validationMessage = validate(rating, comment);
        if (validationMessage != null) return validationMessage;

        Jewelry jewelry = DBMainRepo.getJewelryList().stream()
                .filter(w -> w.getTitle().equals(jewelryName))
                .findFirst()
                .orElse(null);
        if (jewelry != null) {
            Rating newRating = new Rating(1L, comment, rating, jewelry);
            DBMainRepo.getRatings().add(newRating);
            return generateMessage(jewelryName, rating);
        }
        return null;
    }

    private String generateMessage(String jewelryName, Integer rating) {
        StringBuilder message = new StringBuilder("Успешно оценихте с ");
        message.append(rating);
        if (rating > 1) {
            message.append(" звезди ");
        } else {
            message.append(" звезда ");
        }
        message.append("бижуто ");
        message.append(jewelryName);
        return message.toString();
    }

    private static String validate(Integer rating, String comment) {
        if (null == rating) {
            return "Въведете оценка";
        }
        if (rating < 1 || rating > 6) {
            return "Оценката трябва да е между 1 и 6";
        }
        if (comment != null && comment.length() > 50) {
            return "Коментара трябва да е с дължина под 51";
        }
        if (comment != null && !comment.matches("[\\w.,!\\p{L}\\s-]+")) {
            return "За коментари може да ползвате букви, цифри и '.,!-'";
        }
        return null;
    }
}
