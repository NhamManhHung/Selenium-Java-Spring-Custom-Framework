package com.auto.framework.pageobjects.demogeniusocean.testdata.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalProduct {
    private String name;
    private String sku;

    private String category;
    private String subCategory;
    private String childCategory;

    private boolean productCondition;
    private boolean preorder;
    private boolean minimumOrderQtyEnabled;
    private boolean estimatedShippingTimeEnabled;
    private boolean wholeSellEnabled;
    private boolean measurementEnabled;
    private boolean colorsEnabled;
    private boolean stockEnabled;

    private int stock;
    private String description;
    private String policy;

    private boolean seoEnabled;
    private String featureImagePath;

    private double currentPrice;
    private double discountPrice;
    private String youtubeUrl;

    private String tags;


}
