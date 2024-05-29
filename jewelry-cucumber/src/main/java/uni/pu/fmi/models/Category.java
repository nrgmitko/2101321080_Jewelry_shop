package uni.pu.fmi.models;

import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String title;
    private String description;
    private Category parentCategory;
    private Set<Category> children;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
