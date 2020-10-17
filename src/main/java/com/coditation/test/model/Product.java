package com.coditation.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("productList")
    private ProductCategory productCategory;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Float productPrice;

    @Column(name = "product_description")
    @Type(type = "text")
    private String productDescription;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "date_created", insertable = false)
    @JsonIgnore
    private Date dateCreated;

    @Column(name = "last_updated", insertable = false)
    @Type(type = "timestamp")
    @JsonIgnore
    private Date lastUpdated;

    @Column(name = "product_stock")
    @NotNull
    private Float productStock;


}
