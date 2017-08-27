import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by casparhuan on 2017/8/23.
 */
public class TestMDC {
    private static Logger logger = LoggerFactory.getLogger(TestMDC.class.getName());



    public static void main(String[] args) {
        MDC.putCloseable("LOGGER_ID", UUID.randomUUID().toString());
        logger.info("开始main的日志");
        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final int finalI = i;
            executors.submit(new Callable<Void>() {
                private Map<String,String> contextMap = MDC.getCopyOfContextMap();
                private Logger loggerCa = LoggerFactory.getLogger(getClass().getName());
                public Void call() throws Exception {
                    MDC.setContextMap(contextMap);  // set contextMap when thread start
                    loggerCa.info("开始main下线程池开的线程的日志:"+ finalI);
                    return null;
                }
            });



        }

        MDC.clear();
        MDC.putCloseable("LOGGER_ID", UUID.randomUUID().toString());
        logger.info("开始main第二次的日志");

        for (int i = 0; i < 10; i++) {

            final int finalI = i;
            executors.submit(new Callable<Void>() {
                private Map<String,String> contextMap = MDC.getCopyOfContextMap();
                private Logger loggerCa = LoggerFactory.getLogger(getClass().getName());
                public Void call() throws Exception {
                    MDC.setContextMap(contextMap);  // set contextMap when thread start
                    loggerCa.info("开始main下线程池开的线程的日志:"+ finalI);
                    return null;
                }
            });



        }



    }
}
