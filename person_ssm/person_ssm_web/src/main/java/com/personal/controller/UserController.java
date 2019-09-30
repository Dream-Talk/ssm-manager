package com.personal.controller;


import com.personal.domain.Role;
import com.personal.domain.UserInfo;
import com.personal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;



    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo info) throws  Exception{
        userService.save(info);
        return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findUserById(userId);
        List<Role> roles = userService.findOtherRoles(userId);
        mv.addObject("userList",user);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/findUserById")
    public ModelAndView findUserByID(@RequestParam( name = "id", required = true, defaultValue = "-1") String userId) throws Exception{
        UserInfo userInfo = userService.findUserById(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addPermissionToRole(
            @RequestParam(name = "userId",required = true) String userId,
            @RequestParam(name = "ids",required = true )String[] roleIds) throws Exception {
            userService.addRoleToUser(userId,roleIds);
        return "redireect:findAll";
    }
}
