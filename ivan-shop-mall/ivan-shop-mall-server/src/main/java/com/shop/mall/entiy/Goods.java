package com.shop.mall.entiy;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Ivan.luo
 * @Description 商品实体类
 * @date 2020/12/29
 */
@Data
@Table(name = "goods")
public class Goods {
    /**
     * 商品主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 发布者id
     */
    private Integer uid;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String detail;

    /**
     * 商品原价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 商品现价
     */
    @Column(name = "present_price")
    private BigDecimal presentPrice;

    /**
     * 分类id
     */
    @Column(name = "classification_id")
    private Integer classificationId;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 商品成色
     */
    private Integer level;

    /**
     * 图片地址
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 是否下架
     */
    @Column(name = "is_offshelf")
    private Integer isOffshelf;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Integer createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Integer updateTime;
}
