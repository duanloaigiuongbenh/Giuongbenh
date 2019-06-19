package com.teamword.controller;

import com.teamword.dao.Giuongbenhlmpl;
import com.teamword.model.Giuongbenh;
import com.teamword.service.GiuongbenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class GiuongbenhController {
//Truyen session Factory vao ccontroller, anh xa mot doi tuong voi bean

    @Autowired
    private Giuongbenhlmpl gbDao;

   @Autowired
    private GiuongbenhService giuongbenhService;
// nhan yeu cau tu url

    /*
    @RequestMapping(value = "giuongbenh/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("giuongbenh/list");
        List<Giuongbenh> dsGiuongbenh =  gbDao.getall();
            mav.addObject("listResult",dsGiuongbenh);
        return mav;
    } */

/*
   @RequestMapping(value = "giuongbenh/list")
    public  ModelAndView list_sv (){
        ModelAndView mav = new ModelAndView("giuongbenh/list");
        List<Giuongbenh> dsGiuongbenh = giuongbenhService.list_sv_name();
        mav.addObject("listResult",dsGiuongbenh);
        return mav;
    }




   /* @RequestMapping(value = "giuongbenh/edit")
    //ModelAttribute nhan tham so tu doi tuong truyen vao, RequetParam nhan tham so yeu tu web
    public ModelAndView editGiuongbenh (@ModelAttribute("gb") Giuongbenh gb, @RequestParam String command){
        ModelAndView mav = new ModelAndView( "giuongbenh/edit");

        //equalsIgnoreCase so sanh hai chuoi khong phan biet hoa thuong
        if (command !=null && command.equalsIgnoreCase("SaveOrEdit")){
             if(gb.getId()!= 0){
             //update
                    gbDao.update(gb);
             }
             else {
                 //save
                    gbDao.create(gb);
             }
             mav = new ModelAndView("redirect:list");
             return mav;
        }
        else {
            gb = gbDao.get(gb.getId());
        }
        if(gb != null && gb.getId()!=0)
        mav.addObject("gb",gb);

        return mav;
    } */
/*

// tach ham addnew
    @RequestMapping (value = "giuongbenh/addnew")
    public ModelAndView addNew(@ModelAttribute("gb") Giuongbenh gb) {
        ModelAndView mav = new ModelAndView( "giuongbenh/edit");
        return mav;
    }
 //Tach ham edit
    @RequestMapping (value = "giuongbenh/editform")
    public ModelAndView edit(@ModelAttribute("gb") Giuongbenh gb){
        ModelAndView mav = new ModelAndView("giuongbenh/edit");
        gb = gbDao.get(gb.getId());
        mav.addObject("gb",gb);
        return mav;
    }
    // thuc hien save or edit tuy thuoc doi tuong truyen di co id  hay ko
    @RequestMapping (value = "giuongbenh/CreateOrEdit", method = RequestMethod.GET)
    public ModelAndView saveGiuongbenh(@ModelAttribute("gb") Giuongbenh gb){
        ModelAndView mav = new ModelAndView("redirect:list");
        if(gb.getId()!= 0){
            //update
            gbDao.update(gb);
            //gbDao.updatequery(gb);
        }
        else {
            //save
           gbDao.create(gb);
          // gbDao.createquery(gb);
        }
        return mav;
    }


    @RequestMapping (value = "giuongbenh/delete")
    public ModelAndView deleteGiuongbenh (@RequestParam int id){
        ModelAndView  mav = new ModelAndView("redirect:list");
        if(id != 0){
                //gbDao.delete(id);
                gbDao.deletequery(id);
        }
        return  mav;

    }
    */

}
