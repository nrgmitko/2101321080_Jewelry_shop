package uni.pu.fmi.jewelryview;

import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.models.Jewelry;

import java.util.List;

@Getter
@Setter
public class JewelryHelperModel {
    private String category;
    private String jewelryName;
    private List<Jewelry> jewelryList;

}