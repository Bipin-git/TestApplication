package com.coditation.test.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "product_category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;
    
    @Column(name = "sub_category_name")
    private String subCategoryName;

}
