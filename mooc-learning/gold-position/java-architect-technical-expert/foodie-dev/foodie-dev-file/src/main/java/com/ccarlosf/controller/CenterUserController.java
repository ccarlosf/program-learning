package com.ccarlosf.controller;

import com.ccarlosf.pojo.Users;
import com.ccarlosf.pojo.vo.UsersVO;
import com.ccarlosf.resourse.FileResource;
import com.ccarlosf.service.FileService;
import com.ccarlosf.service.center.CenterUserService;
import com.ccarlosf.utils.CookieUtils;
import com.ccarlosf.utils.JSONResult;
import com.ccarlosf.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("fdfs")
public class CenterUserController extends BaseController {

    @Autowired
    private FileResource fileResource;

    @Autowired
    private CenterUserService centerUserService;

    @Autowired
    private FileService fileService;

    @PostMapping("uploadFace")
    public JSONResult uploadFace(
            String userId,
            MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String path = "";
        // 开始文件上传
        if (file != null) {
            // 获得文件上传的文件名称
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotBlank(fileName)) {

                // 文件重命名  imooc-face.png -> ["imooc-face", "png"]
                String fileNameArr[] = fileName.split("\\.");

                // 获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];

                if (!suffix.equalsIgnoreCase("png") &&
                        !suffix.equalsIgnoreCase("jpg") &&
                        !suffix.equalsIgnoreCase("jpeg") ) {
                    return JSONResult.errorMsg("图片格式不正确！");
                }

//                path = fileService.upload(file, suffix);

                path = fileService.uploadOSS(file, userId, suffix);
                System.out.println(path);
            }
        } else {
            return JSONResult.errorMsg("文件不能为空！");
        }

        if (StringUtils.isNotBlank(path)) {
//            String finalUserFaceUrl = fileResource.getHost() + path;
            String finalUserFaceUrl = fileResource.getOssHost() + path;

            Users userResult = centerUserService.updateUserFace(userId, finalUserFaceUrl);

            UsersVO usersVO = conventUsersVO(userResult);

            CookieUtils.setCookie(request, response, "user",
                    JsonUtils.objectToJson(usersVO), true);
        } else {
            return JSONResult.errorMsg("上传头像失败");
        }

        return JSONResult.ok();
    }

}
