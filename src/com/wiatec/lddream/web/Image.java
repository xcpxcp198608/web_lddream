package com.wiatec.lddream.web;

import com.wiatec.lddream.orm.pojo.ImageInfo;
import com.wiatec.lddream.orm.pojo.ManagerInfo;
import com.wiatec.lddream.service.AdImageService;
import com.wiatec.lddream.service.ManagerService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * web ad image
 */
@Controller
@RequestMapping(value = "/image")
public class Image {

    @Resource
    private ManagerService managerService;
    @Resource
    private AdImageService adImageService;

    @RequestMapping(value = "/validate")
    public String validate(@ModelAttribute ManagerInfo managerInfo){
        if(managerService.validate(managerInfo)){
            return "redirect: show";
        }else {
            throw new RuntimeException("no authority");
        }
    }

    @RequestMapping(value = "/show")
    public String show(Model model, HttpServletRequest request){
        validateRequest(request);
        List<ImageInfo> imageInfoList = adImageService.selectAll();
        model.addAttribute("imageInfoList", imageInfoList);
        return "adimage/show";
    }

    @RequestMapping(value = "/edit")
    public String goEdit(@RequestParam int id, Model model, HttpServletRequest request){
        validateRequest(request);
        ImageInfo imageInfo = adImageService.selectById(id);
        model.addAttribute("imageInfo", imageInfo);
        return "adimage/edit";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam MultipartFile file, @RequestParam int id,
                         HttpServletRequest request, Model model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/Resource/image/");
        String fileName = file.getOriginalFilename();
        if(!file.isEmpty()){
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
        }
        adImageService.updateOne(fileName, id);
        return "redirect: show";
    }

    @RequestMapping(value = "/add")
    public String goAdd(HttpServletRequest request){
        validateRequest(request);
        return "adimage/add";
    }

    @RequestMapping(value = "/insert")
    public String insert(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/Resource/image/");
        String fileName = file.getOriginalFilename();
        if(!file.isEmpty()){
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
        }
        adImageService.insertOne(fileName);
        return "redirect: show";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam() int id, HttpServletRequest request){
        validateRequest(request);
        adImageService.deleteById(id);
        return "redirect: show";
    }

    private void validateRequest(HttpServletRequest request){
        try {
            String ref = request.getHeader("referer");
            if (!ref.contains("/lddream/")) {
                throw new RuntimeException("login info error");
            }
        }catch (Exception e){
            throw new RuntimeException("login info error");
        }
    }
}
