package iesch.org.GestionDeInventarioProductos.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int stock;

}
