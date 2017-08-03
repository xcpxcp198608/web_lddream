package com.wiatec.lddream.service;

import com.wiatec.lddream.instance.Constant;
import com.wiatec.lddream.orm.dao.AdImageDao;
import com.wiatec.lddream.orm.pojo.ImageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuchengpeng on 22/07/2017.
 */
@Service
public class AdImageService {

    @Resource
    private AdImageDao adImageDao;

    @Transactional(readOnly = true)
    public List<ImageInfo> selectAll(){
        return adImageDao.selectAll();
    }

    @Transactional(readOnly = true)
    public ImageInfo selectById(int id){
        return adImageDao.selectById(id);
    }

    @Transactional
    public void deleteById(int id){
        adImageDao.deleteById(id);
    }

    @Transactional
    public void insertOne(String fileName){
        if(fileName == null){
            return;
        }
        String url = Constant.path.upload+fileName;
        ImageInfo imageInfo = new ImageInfo(fileName, url,"1");
        adImageDao.insertOne(imageInfo);
    }

    @Transactional
    public void updateOne(String  fileName, int id){
        if(fileName == null){
            return;
        }
        String url = Constant.path.upload+fileName;
        ImageInfo imageInfo = new ImageInfo(id, fileName, url,"1");
        adImageDao.updateOne(imageInfo);
    }
}
