package com.tw.core.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhihuizhang on 7/14/15.
 */
public class CookieHelper {

    public static void saveCookie(String cookieName, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        response.addCookie(cookie);
    }

    public static String getCookieValue(String cookieName, HttpServletRequest request) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            int i = 0;
            boolean cookieExists = false;
            while (!cookieExists && i < cookies.length) {
                if (cookies[i].getName().equals(cookieName)) {
                    cookieExists = true;
                    value = cookies[i].getValue();
                } else {
                    i++;
                }
            }
        }
        return value;
    }

    public static void deleteCookie(String cookieName, HttpServletResponse response) {

        Cookie cookie = new Cookie("currentUser", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
