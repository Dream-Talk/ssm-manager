package com.personal.controller;

import com.personal.domain.Permission;
import com.personal.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermission permissionDao;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionDao.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }
}
