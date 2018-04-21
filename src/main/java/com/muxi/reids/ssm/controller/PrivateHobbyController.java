package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-30 09:51
 */

import com.muxi.reids.ssm.entity.EssayInfo;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.AlterInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "hobby")
@SessionAttributes({"allHobby"})
public class PrivateHobbyController {

    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;

    @Autowired
    private InCommonUse inCommonUse;

    /*添加心情记录*/
    @RequestMapping(value = "/addHobby", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addHobby(String text) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (addInformationServices.addEssay(text, inCommonUse.achieveNowTime()))
            map.put("addHobby", "success");
        else
            map.put("addHobby", "error");
        return map;
    }

    /*查询性情记录 并排序*/
    @RequestMapping(value = "/readHobby", method = RequestMethod.GET)
    public String readHobby(ModelMap modelMap){
        List<EssayInfo> essayInfoList = readInformationServices.readEssayAll();
        modelMap.addAttribute("allHobby",essayInfoList);
        return "../BlogHobby";
    }



    public void setAddInformationServices(AddInformationServices addInformationServices) {
        this.addInformationServices = addInformationServices;
    }

    public void setAlterInformationServices(AlterInformationServices alterInformationServices) {
        this.alterInformationServices = alterInformationServices;
    }

    public void setInCommonUse(InCommonUse inCommonUse) {
        this.inCommonUse = inCommonUse;
    }
}
