package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
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
    private Set<Rating> ratings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jewelry jewelry = (Jewelry) o;
        return Objects.equals(id, jewelry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
