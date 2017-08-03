package com.wiatec.lddream.api;

import com.wiatec.lddream.orm.pojo.ImageInfo;
import com.wiatec.lddream.service.AdImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuchengpeng on 22/07/2017.
 */
@Controller
@RequestMapping(value = "/adimage")
public class AdImage {

    @Resource
    private AdImageService adImageService;

    @RequestMapping(value = "/")
    public @ResponseBody List<ImageInfo> getAll(){
        return adImageService.selectAll();
    }
}
