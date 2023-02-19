package libs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String id;
    private String dataCode;
    private String title;
    private String category;
    private String path;
}
