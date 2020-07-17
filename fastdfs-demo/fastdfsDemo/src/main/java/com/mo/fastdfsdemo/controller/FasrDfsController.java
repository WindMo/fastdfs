package com.mo.fastdfsdemo.controller;
import com.mo.fastdfsdemo.VerifyCodeConfig;
import com.mo.fastdfsdemo.utils.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WindShadow
 * @verion 2020/2/17.
 */

@Controller
@RequestMapping("/demo")
public class FasrDfsController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadFile(String username, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){

        Map<String,Object> modelMap = new HashMap<String,Object>();
        // 验证码判断
        if (!(CodeUtil.checkVerifyCode(request, VerifyCodeConfig.KAPTCHA_SESSION_KEY,"verifyCodeActual-"))){

            modelMap.put("code","error");
        }else {

            modelMap.put("code","yes");
        }
        if (!(username == null || "".equals(username)))
            modelMap.put("username",username);
        else {

            modelMap.put("username","no username");
        }
        // 是否上传文件且为非空文件
        if (multipartFile == null || multipartFile.isEmpty()){

            modelMap.put("succeed",false);
        }else {

            System.out.println(multipartFile.getContentType());
            System.out.println(multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getName());
            modelMap.put("succeed",true);
        }
        return modelMap;
    }

    @RequestMapping("/json")
    @ResponseBody
    public String getJson(){

        return "msg:koko";
    }

    @RequestMapping("/test")
    public String test(){

        return "index";
    }
}
