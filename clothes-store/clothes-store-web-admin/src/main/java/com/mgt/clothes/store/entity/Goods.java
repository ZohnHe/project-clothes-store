package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import lombok.Data;

import java.io.Serializable;
@Data
public class Goods extends AbstractBaseEntity implements Serializable {

   private String goodsName;
   private long goodsTypeid;
   private String goodsDesc;
   private Integer goodsPrice;
   private int goodsStock;
   private String image;

}
