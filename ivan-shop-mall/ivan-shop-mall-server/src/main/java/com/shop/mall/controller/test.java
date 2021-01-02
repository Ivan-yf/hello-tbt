package com.shop.mall.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.shop.mall.entiy.Goods;
import com.shop.mall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Ivan.luo
 * @Description
 * @date 2020/12/05
 */
@RestController
public class test {
    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Value("${oss.path}")
    private String path;

    @Resource
    GoodsMapper goodsMapper;

    @GetMapping("/test")
    public void test() {

        Goods goods = new Goods();
        goods.setUid(1);
        goodsMapper.insert(goods);

        System.out.println("hello");
    }

    @ResponseBody
    @PostMapping(value="/upload")
    public void upload(@RequestParam("filenames") MultipartFile[] multipartFiles) {
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String oldName = multipartFile.getOriginalFilename();
                InputStream inputStream = multipartFile.getInputStream();
                String newName = UUID.randomUUID().toString().replace("-", "").substring(4, 16) + "_" + oldName;
                OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                oss.putObject(bucketName, path + newName, inputStream);
                oss.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @PostMapping("/test2")
    @ResponseBody
    public String test2(@RequestBody String s) {
        System.out.println(s);
        return "/test2";
    }
}
