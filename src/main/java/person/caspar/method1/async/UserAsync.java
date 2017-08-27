package person.caspar.method1.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import person.caspar.method1.dao.UserDao;
import person.caspar.method1.util.StringUtil;

/**
 * Created by casparhuan on 2017/8/23.
 */
@Component
public class UserAsync {

    private Logger logger = LoggerFactory.getLogger(UserAsync.class.getName());

    @Autowired
    private UserDao userDao;

    @Async
    public void asyncSendMsgToEmail(String user,String psw,String mail,String loggerID){
        logger.info("loggerID:{},==============asyncSendMsgToEmail(),user:{},psw:{},mail:{}",loggerID,user,psw,mail);
        String solvedPsw = StringUtil.INSTANCE.replace(psw,2,4,'*');//将密码从下标为2开始4个字符串替代成*
        userDao.sendMsgToEmail(user,solvedPsw,mail,loggerID);
    }
}
