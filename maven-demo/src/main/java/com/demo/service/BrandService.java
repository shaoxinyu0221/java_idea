package com.demo.service;

import com.demo.entity.Brand;

import java.util.Arrays;
import java.util.List;

public class BrandService {

    public static List<Brand> getBrandList(){
        Brand b1 = new Brand();
        b1.setId(1);
        b1.setName("惠普");
        b1.setPrice(3000);
        Brand b2 = new Brand();
        b2.setId(2);
        b2.setName("联想");
        b2.setPrice(5000);
        Brand b3 = new Brand();
        b3.setId(3);
        b3.setName("IBM");
        b3.setPrice(4000);
        Brand b4 = new Brand();
        b4.setId(4);
        b4.setName("方正");
        b4.setPrice(8000);
        Brand b5 = new Brand();
        b5.setId(5);
        b5.setName("海尔");
        b5.setPrice(6000);

        List<Brand> brandList = Arrays.asList(b1, b2, b3, b4, b5);

        return brandList;

    }

}
