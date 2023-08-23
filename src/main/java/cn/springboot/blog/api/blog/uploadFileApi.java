package cn.springboot.blog.api.blog;


import cn.springboot.blog.api.blog.param.MallUserUpdateParam;
import cn.springboot.blog.api.blog.param.fileParams;
import cn.springboot.blog.common.Constants;
import cn.springboot.blog.dao.UsersMapper;
import cn.springboot.blog.entity.Users;
import cn.springboot.blog.service.MallUserService;
import cn.springboot.blog.util.MallUtils;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import cn.springboot.blog.util.SystemUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;

@RestController
@Api(value = "v1", tags = "文件上传相关接口")
@RequestMapping("/api/v1")
public class uploadFileApi {

    private static final Logger logger = LoggerFactory.getLogger(uploadFileApi.class);

    @Autowired
    MallUserService mallUserService;

    @Autowired
    private StandardServletMultipartResolver standardServletMultipartResolver;

    /**
     * 图片上传
     */
    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
    @ApiOperation(value = "单图上传", notes = "file Name \"file\"")
    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file,@RequestParam String originalPath) throws URISyntaxException {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(Constants.FILE_UPLOAD_DIC);
        //创建文件
        File destFile = new File(Constants.FILE_UPLOAD_DIC + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            boolean isDelete = SystemUtil.deleteFile(Constants.FILE_UPLOAD_DIC + originalPath);
            if(isDelete){
                Result resultSuccess = ResultGenerator.genSuccessResult();
                resultSuccess.setData(newFileName);
                return resultSuccess;
            }
            return ResultGenerator.genFailResult("原头像删除失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件上传失败");
        }
    }

    /**
     * 图片上传
     */
    @RequestMapping(value = "/upload/files", method = RequestMethod.POST)
    @ApiOperation(value = "多图上传", notes = "wangEditor图片上传")
    public Result uploadV2(HttpServletRequest httpServletRequest,@RequestParam("files") List<MultipartFile> multipartFiles) throws URISyntaxException {

        if (CollectionUtils.isEmpty(multipartFiles)) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (multipartFiles != null && multipartFiles.size() > 10) {
            return ResultGenerator.genFailResult("最多上传10张图片");
        }
        List<String> fileNames = new ArrayList(multipartFiles.size());
        for (int i = 0; i < multipartFiles.size(); i++) {
            String fileName = multipartFiles.get(i).getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //生成文件名称通用方法
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random r = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
            String newFileName = tempName.toString();
            File fileDirectory = new File(Constants.FILE_Dynamic_DIC);
            //创建文件
            File destFile = new File(Constants.FILE_Dynamic_DIC + newFileName);
            try {
                if (!fileDirectory.exists()) {
                    if (!fileDirectory.mkdir()) {
                        throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                    }
                }
                multipartFiles.get(i).transferTo(destFile);
                fileNames.add(newFileName);
            } catch (IOException e) {
                e.printStackTrace();
                return ResultGenerator.genFailResult("文件上传失败");
            }
        }
        Result resultSuccess = ResultGenerator.genSuccessResult();
        resultSuccess.setData(fileNames);
        return resultSuccess;
    }
}
