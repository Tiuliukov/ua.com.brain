package libs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static libs.ProductDTO.*;

/**
 * Valid test data for test cases
 */
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
            .build()),
    GP2AA(builder()
            .id("15AU-U2 / 4891199027581")
            .dataCode("U0434777")
            .title("Батарейка Gp AA LR6 Ultra Alcaline * 2 (15AU-U2 / 4891199027581)")
            .category("Батарейки")
            .path("Batareyka_GP_AA_LR6_Ultra_Alcaline_2_GP15AU-2UE2-p694768.html")
            .build());

    private ProductDTO productDTO;

    public ProductDTO getDTO() {
        return productDTO;
    }

}
