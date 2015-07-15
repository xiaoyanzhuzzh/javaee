package com.tw.core.controller;

import com.tw.core.helper.CookieHelper;
import com.tw.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SessionController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView getLoginPage() {

        return new ModelAndView("login");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name,
                              @RequestParam String password,
                              HttpServletRequest request){


        if(adminService.verifyAdminInfo(name, password)) {

            request.getSession().setAttribute("currentUser", name);

        }

        String url = request.getHeader("referer");

        if(url.equals("http://localhost:8080/web/login")) {

            url = "/users/";
            return new ModelAndView("redirect:" + url);
        } else {

        return new ModelAndView("redirect:" + url);
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request){

        request.getSession().removeAttribute("currentUser");
        return new ModelAndView("redirect:/login");
    }
}
