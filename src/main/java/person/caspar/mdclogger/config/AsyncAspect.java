package person.caspar.mdclogger.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import person.caspar.mdclogger.App;

/**
 * Created by casparhuan on 2017/8/23.
 */
@Aspect
@Component
public class AsyncAspect {

    @Pointcut("execution(* person.caspar.mdclogger.async.*.async*(..))")
    public void newThreadAddLoggerID() {
    }

    @Before("newThreadAddLoggerID()")
    public void beforeInvoked2(final JoinPoint joinPoint) {
        MDC.put("LOGGER_ID", (String) App.loggerIDInheritableThreadLocal.get());
    }

}
