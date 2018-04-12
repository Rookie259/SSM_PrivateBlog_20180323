package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-10 15:55
 */

import com.muxi.reids.ssm.entity.LeaveNoteInfo;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.AlterInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "note")
public class LeaveNoteController {
    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;

    @Autowired
    private InCommonUse inCommonUse;

    /*博客留言*/
    @RequestMapping(value = "/leaveNote")
    @ResponseBody
    public Map<String, Object> leaveNote(String text) {
        Map<String, Object> map = new HashMap<String, Object>();
        LeaveNoteInfo leaveNoteInfo = new LeaveNoteInfo();
        try {
            leaveNoteInfo.setLnname(inCommonUse.getIpAddress());
             //TODO
        } catch (UnknownHostException e) {
            /*获取时间戳后六位*/
            leaveNoteInfo.setLnname("佚名" + new String(String.valueOf(System.currentTimeMillis()).substring(String.valueOf(System.currentTimeMillis()).length() - 8, String.valueOf(System.currentTimeMillis()).length())));
            e.printStackTrace();
        }
        return map;
    }


    public void setReadInformationServices(ReadInformationServices readInformationServices) {
        this.readInformationServices = readInformationServices;
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
