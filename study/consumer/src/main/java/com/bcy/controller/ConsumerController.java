package com.bcy.controller;

import com.bcy.service.ProviderClientSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {
    @Autowired
    ProviderClientSub providerClient;

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        //前端传入的时间格式必须是"yyyy-MM-dd"效果!
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerClient.hi("feign");
    }

    @GetMapping("/bind")
    public Map<String,Object> bindTest(@RequestParam Date date){
        Map<String,Object> map=new HashMap<>();
        map.put("name","Kaz");
        map.put("time",date);
        return map;
    }
}
