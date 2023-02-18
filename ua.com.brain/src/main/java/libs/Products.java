package libs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static libs.ProductDTO.*;

@Getter
@ToString
@AllArgsConstructor
public enum Products {
    Duracell2AA(builder()
            .id("5000394058163 / 81551267")
            .dataCode("ET03771")
            .title("Батарейка Duracell AA MN1500 LR06 * 2 (5000394058163 / 81551267)")
            .category("Батарейки")
            .path("Batareyka_Duracell_AA_MN1500_LR06_2_81417078_81267329-p24421.html")
            .build());

    private ProductDTO productDTO;

    public ProductDTO getDTO() {
        return productDTO;
    }

}
