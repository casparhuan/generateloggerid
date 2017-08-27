package person.caspar.mdclogger.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by casparhuan on 2017/8/23.
 */
@Component
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class.getName());
    public void sendMsgToEmail(String user,String psw,String mail){
        logger.info("user:{},psw:{},send msg to mail ",user,psw);
        if (user.equals("exception")){
            Exception e = new Exception("dumpling name");
            logger.error("happened exception,msg:{}",e.getMessage(),e);
        }else{
            logger.info("send msg to email success");
        }
    }

    public void insertUser(String user,String psw){
        logger.info("saving user , user: {} ,psw:{}",user,psw);
        try {
            TimeUnit.SECONDS.sleep(5);  //模拟处理过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("save user , user: {} ,psw:{} success",user,psw);
    }

}
