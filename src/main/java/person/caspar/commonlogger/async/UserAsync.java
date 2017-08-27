package person.caspar.commonlogger.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import person.caspar.commonlogger.dao.UserDao;
import person.caspar.commonlogger.util.StringUtil;

/**
 * Created by casparhuan on 2017/8/23.
 */
@Component
public class UserAsync {

    private Logger logger = LoggerFactory.getLogger(UserAsync.class.getName());

    @Autowired
    private UserDao userDao;

    @Async
    public void asyncSendMsgToEmail(String user,String psw,String mail){
        logger.info("loggerID:{},==============asyncSendMsgToEmail(),user:{},psw:{},mail:{}",user,psw,mail);
        String solvedPsw = StringUtil.INSTANCE.replace(psw,2,4,'*');//将密码从下标为2开始4个字符串替代成*
        userDao.sendMsgToEmail(user,solvedPsw,mail);
    }
}
