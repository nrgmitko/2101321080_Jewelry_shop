package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class Jewelry {
    private Long id;
    private String title; //
    private String description;
    private int quantity;
    private double price;
    private Set<Category> categories;
}