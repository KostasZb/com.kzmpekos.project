package com.example.demo.controllers;

import com.example.demo.services.UserService;
import com.example.demo.viewmodels.UserHomeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("")
public class UserController {
    private final String pageFolder="user/";
    //@Autowired
    //private UserService userService;

    //public UserController(){
      // UserService userService=new UserService();
    //}

    @GetMapping(value={"","/"})
    public String user(){
        return pageFolder+"home";
    }

    @PostMapping(value="/login")
    public ModelAndView login(String email,String password){
        UserService userService=new UserService();
        UserHomeViewModel viewModel=new UserHomeViewModel(userService.LogInUser(email,password));
        ModelAndView userHome=createModelAndView(pageFolder+"home","home_user",viewModel);
        return userHome;
    }
    private ModelAndView createModelAndView(String viewName,String objectName,Object t){
        ModelAndView mav=new ModelAndView();
        mav.setViewName(viewName);
        mav.addObject(objectName,t);
        return mav;
    }
}
