package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("users", userService.getUsers());

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createUser");

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam int age,
                                   @RequestParam String email){

        User user = new User(name, gender, age, email);
        userService.createUser(user);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id){

        userService.deleteUserById(id);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(@RequestParam int id){
        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam int id,
                                   @RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam int age,
                                   @RequestParam String email){
        User user = new User(id, name, gender, age, email);
        userService.updateUser(user);

        return new ModelAndView("redirect:/");
    }
}
