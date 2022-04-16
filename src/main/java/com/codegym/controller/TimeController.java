package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name="city",required = false,defaultValue = "Asia/Ho-Chi_Minh")String city){
//lay ra thoi gian hien tai
        Date date=new Date();
        //lay ra time zone hien tai
        TimeZone local=TimeZone.getDefault();
        //lay ra time zone cua mot thanh pho cu the
        TimeZone locale= TimeZone.getTimeZone(city);
        //tinh thoi gian hien tai cua mot thanh pho
        long local_time= date.getTime() +
                (locale.getRawOffset()-local.getRawOffset());
        //cai dat lai thoi gian cho bien date thanh thoi gian hien tai cua 1 thanh pho cu the
        date.setTime(local_time);
        //chuyen du lieu qua view
        model.addAttribute("city",city);
        model.addAttribute("date",date);

        return "index";
    }
}
