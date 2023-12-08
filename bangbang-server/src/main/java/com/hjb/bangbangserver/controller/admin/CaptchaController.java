package com.hjb.bangbangserver.controller.admin;

import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  验证码对应的controller
 */
@Controller
@RequestMapping("/admin")
@Api(tags = "验证码相关接口")
public class CaptchaController {

    @GetMapping("/captcha")
    @ApiOperation(value = "生成验证码")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /**
         * 自动生成验证码图片 写回!
         * 并且:将验证码图片存储到session,  key = captcha 默认:4个字母
         */
        CaptchaUtil.out(request,response);
    }
}
