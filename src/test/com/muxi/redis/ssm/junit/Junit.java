package muxi.redis.ssm.junit;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 10:20
 */

import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.AlterInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.Eamil.EamilTool;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-config.xml","classpath:application-MyBatis.xml"})
public class Junit {

    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;


    private EamilTool eamilTool = new EamilTool();

    @Autowired
    private  InCommonUse inCommonUse;

    @Test
    public void test(){
       /* String str = "2018-03-28 15:35:32";
        String str_month = inCommonUse.bracketsByValue(str,'-','-');
        String str_day = inCommonUse.bracketsByValue(str,'-',' ');
        System.out.println(str_month);
        System.out.println(str_day);*/
     /*   ClassifyInfo classifyInfo = readInformationServices.readClassify("技术类");
        System.out.println(classifyInfo.getClcomment());*/
       /* UserInfo userInfo = new UserInfo();
        userInfo.setuEamil("123");
        userInfo.setuPassword("123");
        boolean flag = readInformationServices.readUserIsExist(userInfo);
        System.out.println(flag);
        userInfo.setuNickName("桓公");
        userInfo.setuTime(eamilTool.achieveNowTime());
        System.out.println(addInformationServices.addUserInfo(userInfo));*/

       /* UserInfo userInfo = new UserInfo();
        userInfo.setuEamil("1503893004@qq.com");
        UserInfo userInfo1 = readInformationServices.readUserInfo(userInfo);

        ClassifyInfo classifyInfo = readInformationServices.readClassify("技术类");

        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setBcontent("123");
        blogInfo.setBtitle("123");
        blogInfo.setBlabel("123");
        blogInfo.setBtime("123124");
        blogInfo.setBstate("预览状态");


        blogInfo.setBuid(userInfo1);
        blogInfo.setBclid(classifyInfo);

        System.out.println(addInformationServices.addPreviewState(blogInfo));
*/
        System.out.println(addInformationServices.addCommentDoubleDeck("测试sssss","看什么看","16","1"));


    }



}
