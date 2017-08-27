package person.caspar.mdclogger.filter;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import person.caspar.mdclogger.App;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * 添加MDC loggeridfilter
 * Created by casparhuan on 2017/8/23.
 */
@Order(1)
@WebFilter(filterName = "mdcFilter",urlPatterns = "/*")
public class MDCFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String loggerID = UUID.randomUUID().toString();
        App.loggerIDInheritableThreadLocal.set(loggerID);
        MDC.put("LOGGER_ID", loggerID);
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {

    }
}
