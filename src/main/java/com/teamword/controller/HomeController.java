package com.teamword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/trang-chu")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("home");
        return mav;

    }

    @RequestMapping(value = "/list_giao_dien")
    public ModelAndView list_giao_dien(){
        ModelAndView mav = new ModelAndView("giuongbenh/list_giaodien");
        return mav;
    }
}
