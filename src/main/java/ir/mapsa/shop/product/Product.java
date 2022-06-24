package ir.mapsa.shop.product;

import ir.mapsa.shop.category.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column (name = "price",nullable = false)
    private Long price;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
