package com.personal.controller;


import com.personal.domain.Role;
import com.personal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll")
    public ModelAndView findAll() throws Exception {
        List<Role> roles = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return  mv;
    }
    @RequestMapping("/save")
    public String save(Role role) throws Exception{
        ModelAndView mv = new ModelAndView();
        System.out.println(role.getRoleName());
        System.out.println(role.getRoleDesc());
        roleService.save(role);
        return "redirect:findAll";
    }

}
