package com.tw.core.controller;

import com.tw.core.helper.CookieHelper;
import com.tw.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class cookieController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletRequest request){

        if(CookieHelper.getCookieValue("currentUser", request) == null){

            return new ModelAndView("login", "loginFailMessage", "");
        } else {

            String previous = CookieHelper.getCookieValue("previousUrl", request);
            return new ModelAndView("redirect:" + previous);
        }
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name,
                              @RequestParam String password,
                              HttpServletResponse response){

        if(adminService.verifyAdminInfo(name, password)) {

            CookieHelper.saveCookie("currentUser", name, response);
            return new ModelAndView("redirect:/users/");
        } else {

            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response){

        CookieHelper.deleteCookie("currentUser", response);
        return new ModelAndView("redirect:/");
    }
}
