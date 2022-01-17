package ru.geekbrains.myonlinestore.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull(message = "не может быть пустым")
    private String title;

    @ManyToOne()
    @NotNull(message = "категория не выбрана")
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "price")
    @NotNull(message = "не может быть пустым")
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductImage> images;

}
