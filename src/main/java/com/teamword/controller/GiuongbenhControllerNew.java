package com.teamword.controller;


import com.teamword.dao.Giuongbenhlmpl;
import com.teamword.model.Giuongbenh;
import com.teamword.service.GiuongbenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class GiuongbenhControllerNew {
    @Autowired
    private Giuongbenhlmpl gbDao;

    @Autowired
    public GiuongbenhService giuongbenhService;

    @RequestMapping(value = "giuongbenh/search", method = RequestMethod.POST, params = "btnsearch")
    public ModelAndView search(@RequestParam("txtsearch") String txtsearch){
        String tim = txtsearch;
        ModelAndView mav = new ModelAndView("giuongbenh/list");
        if(tim.equals("All")){

            List<Giuongbenh> dsGiuongbenh = giuongbenhService.list_sv();
            mav.addObject("listResult",dsGiuongbenh);
        }
        else
        {
        List<Giuongbenh> dsGiuongbenh = giuongbenhService.list_name(txtsearch);
            mav.addObject("listResult",dsGiuongbenh);
        }

        return mav;
    }

    @RequestMapping(value ="giuongbenh/list")
    public ModelAndView list_servic(@RequestParam(value = "gia",required = false) BigDecimal price){
        BigDecimal gia = price ;
        ModelAndView mav = new ModelAndView("giuongbenh/list");
        List<Giuongbenh> dsGiuongbenh = giuongbenhService.list_sv();
        mav.addObject("listResult",dsGiuongbenh);
        return mav;
    }



    @RequestMapping(value = "giuongbenh/addnew")
    public  ModelAndView addnew_sv(@ModelAttribute("gb") Giuongbenh gb){
        ModelAndView mav = new ModelAndView("giuongbenh/edit");
        return mav;
    }

    @RequestMapping(value = "giuongbenh/editform")
    public ModelAndView edit (@ModelAttribute("gb") Giuongbenh gb){
        ModelAndView  mav = new ModelAndView("giuongbenh/edit");
        gb = gbDao.get(gb.getId());
        mav.addObject("gb",gb);
        return mav;
    }



    @RequestMapping(value = "giuongbenh/CreateOrEdit", method = RequestMethod.GET)
    public ModelAndView saveGiuongBenh(@ModelAttribute("gb") Giuongbenh gb ){
        ModelAndView mav = new ModelAndView("redirect:list");
        if (gb.getId() != 0){
            gbDao.update(gb);
        }
        else{
            gbDao.create(gb);
        }
        return mav;
    }



    @RequestMapping(value = "giuongbenh/delete")
    public  ModelAndView deleteGiuongbenh(@RequestParam int id){
        ModelAndView mav = new ModelAndView("redirect:list");
        if (id != 0){
            gbDao.delete(id);

        }

        return mav;
    }


    @RequestMapping(value ="giuongbenh/save", method = RequestMethod.POST, params ="btnSave")
    public ModelAndView save_form (@RequestParam("name") String name , @RequestParam("price") BigDecimal price,
                                   @RequestParam("description") String description  ){
        ModelAndView mav = new ModelAndView("redirect:list");
        Giuongbenh gb = new Giuongbenh(name,price,description);
        gbDao.create(gb);
        return  mav;
    }

    @RequestMapping(value ="giuongbenh/edit" ,method = RequestMethod.POST,params ="btnEdit" )
    public ModelAndView edit_form (@RequestParam("name-edit") String name, @RequestParam("price-edit") BigDecimal price,@RequestParam("description") String description){
        ModelAndView mav = new ModelAndView("redirect:list");
        Giuongbenh gb= new Giuongbenh();
        if (gb.getId() != 0){
            gbDao.update(gb);
        }
        else{
            gbDao.create(gb);
        }
        return mav;
    }


}
