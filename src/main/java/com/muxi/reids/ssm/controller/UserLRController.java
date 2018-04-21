package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 10:06
 */

import com.muxi.reids.ssm.entity.UserInfo;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.Eamil.EamilTool;
import com.muxi.reids.ssm.tool.MD5.MD5_Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/userController")
@SessionAttributes("user")
public class UserLRController {
    /*测试github更新代码上传*/
    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;


    private EamilTool eamilTool = new EamilTool();


    /*
     *   @Author: MuXi
     *   @ClassName: UserLRController
     *   @param:  * @param null
     *   @Date: 14:08 2018/3/22
     *   @Description: 检测邮箱密码是否正确
     */
    @RequestMapping(value = "/userLogin")
    @ResponseBody
    public Map<String, Object> userIsExist(Model model, UserInfo userInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userInfo.setuPassword(new MD5_Password().getMD5(userInfo.getuPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (readInformationServices.readUserIsExist(userInfo) == false)
            map.put("loginState", "noExist");
        else {
            UserInfo userInfo1 = readInformationServices.readUserInfo(userInfo);
            model.addAttribute("user", userInfo1);
            map.put("loginState", "exist");
        }
        return map;
    }


    /*
     *   @Author: MuXi
     *   @ClassName: UserLRController
     *   @param:  * @param null
     *   @Date: 14:08 2018/3/22
     *   @Description: 判断注册用户昵称是否存在
     *   @Return:
     */
    @RequestMapping(value = "/userNicknameIsExist")
    @ResponseBody
    public Map<String, Object> userNickNameIsExist(Model model, String nickName) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (readInformationServices.readUserNicknameIsExist(nickName))
            map.put("nicknameState", "exist");
        else
            map.put("nicknameState", "noExist");
        return map;
    }

    /*判断输入注册密码是否正确*/
    @RequestMapping(value = "checkRegisterIsOk")
    public String checkRegisterIsOk(ModelMap modelMap, String passText) {
        return "redirect:/rs9780876";
    }


    /*
     *   @Author: MuXi
     *   @ClassName: UserLRController
     *   @param:  * @param null
     *   @Date: 14:30 2018/3/22
     *   @Description: 检测邮箱是否已经被注册
     */
    @RequestMapping(value = "/userEamilIsExist")
    @ResponseBody
    public Map<String, Object> userEamilIsExist(Model model, String eamil) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (readInformationServices.readUserEamilIsExist(eamil))
            map.put("userEamilState", "exist");
        else
            map.put("userEamilState", "noExist");
        return map;
    }


    /*
     *   @Author: MuXi
     *   @ClassName: UserLRController
     *   @param:  * @param null
     *   @Date: 14:53 2018/3/22
     *   @Description: 获取验证码
     *   @Return:
     */
    @RequestMapping(value = "/userAchieveCode")
    @ResponseBody
    public Map<String, Object> userAchieveCode(Model model, String userEamil) {
        Map<String, Object> map = new HashMap<String, Object>();
        String code = readInformationServices.achieveCode(userEamil);
        map.put("code", code);
        return map;
    }


    /*
     *   @Author: MuXi
     *   @ClassName: UserLRController
     *   @param:  * @param null
     *   @Date: 15:24 2018/3/22
     *   @Description: 注册用户
     *   @Return: boolean
     */
    @RequestMapping(value = "/userRegister")
    @ResponseBody
    public Map<String, Object> userRegister(Model model, UserInfo userInfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        userInfo.setuTime(eamilTool.achieveNowTime());
        if (addInformationServices.addUserInfo(userInfo))
            map.put("registerState", "registerSuccess");
        else
            map.put("registerState", "registerError");
        return map;
    }

}
