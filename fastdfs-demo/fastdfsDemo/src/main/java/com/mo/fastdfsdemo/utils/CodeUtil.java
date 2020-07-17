package com.mo.fastdfsdemo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WindShadow
 * @verion 2020/2/18.
 */

public class CodeUtil {

    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request,String sessionKey,String parameterName) {

        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(sessionKey);
        //获取用户输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request,parameterName);
        return verifyCodeActual != null && verifyCodeActual.equalsIgnoreCase(verifyCodeExpected);
    }
}
