package libs;

import lombok.Builder;
import lombok.Data;

/**
 * class which describes main information about products in store.
 */
@Data
@Builder
public class ProductDTO {
    private String id;
    private String dataCode;
    private String title;
    private String category;
    private String path;
}
