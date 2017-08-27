package person.caspar.method1.controller;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.caspar.method1.async.UserAsync;
import person.caspar.method1.dao.UserDao;

import java.util.Map;
import java.util.UUID;

/**
 * Created by casparhuan on 2017/8/23.
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAsync userAsync;
    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/regist")
    public Map<String,Object> regist(String user,String psw,String mail){
        String loggerID = UUID.randomUUID().toString();
        logger.info("loggerID:{},come in save user:{}" ,loggerID,user);
        userDao.insertUser(user,psw,loggerID);
        userAsync.asyncSendMsgToEmail(user,psw,mail,loggerID);
        Map<String,Object> retMap = Maps.newHashMap();
        retMap.put("code","200");
        logger.info("结束");
        return retMap;
    }

}
