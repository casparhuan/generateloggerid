package person.caspar.method1.dao;

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

    public void sendMsgToEmail(String user,String psw,String mail,String loggerID){
        logger.info("loggerID:{},user:{},psw:{},send msg to mail ",loggerID,user,psw);
        if (user.equals("exception")){
            Exception e = new Exception("dumpling name");
            logger.error("loggerID:{},happened exception,msg:{}",loggerID,e.getMessage(),e);
        }else{
            logger.info("loggerID:{},send msg to email success",loggerID);
        }
    }

    public void insertUser(String user,String psw,String loggerID){
        logger.info("loggerID:{},saving user , user: {} ,psw:{}",loggerID,user,psw);
        try {
            TimeUnit.SECONDS.sleep(5);  //模拟处理过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("loggerID:{},save user , user: {} ,psw:{} success",loggerID,user,psw);
    }
}
