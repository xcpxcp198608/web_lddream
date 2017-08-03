package com.wiatec.lddream.orm.dao;

import com.wiatec.lddream.orm.pojo.ImageInfo;

import java.util.List;

/**
 * Created by xuchengpeng on 22/07/2017.
 */
public interface AdImageDao {
    List<ImageInfo> selectAll();
    ImageInfo selectById(int id);
    void deleteById(int id);
    void insertOne(ImageInfo imageInfo);
    void updateOne(ImageInfo imageInfo);
}
