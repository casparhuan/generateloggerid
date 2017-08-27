package person.caspar.mdclogger.controller;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.caspar.mdclogger.async.UserAsync;
import person.caspar.mdclogger.dao.UserDao;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        logger.info("come in save user:{}" ,user);
        userDao.insertUser(user,psw);
        userAsync.asyncSendMsgToEmail(user,psw,mail);
        Map<String,Object> retMap = Maps.newHashMap();
        retMap.put("code","200");
        logger.info("结束");
        return retMap;
    }

}
