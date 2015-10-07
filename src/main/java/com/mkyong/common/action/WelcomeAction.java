package com.mkyong.common.action;

import jndi.AppLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Dictionary;
import java.util.Hashtable;

public class WelcomeAction extends Action{

    //Get a logger
    private static final Logger logger = LogManager.getRootLogger();

    private static final Logger logger2 = LogManager.getLogger("com.mkyong.common.action");

    final static org.slf4j.Logger loggerSl4j = LoggerFactory.getLogger("com.mkyong.common.action");

    final static org.slf4j.Logger loggerSl4j2 = LoggerFactory.getLogger(WelcomeAction.class);

    public ActionForward execute(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response)
            throws Exception {

        //logs debug
//        if(logger.isDebugEnabled()){
//            logger.debug("WelcomeAction.execute()");
//        }
//        logger.debug("Debug");
//        logger.info("Info");
//        logger.warn("warn");
        //logs exception
        //logger.error("This is Error message", new Exception("Testing"));

        MDC.put("Father_Nin_Old", String.valueOf("11"));
        MDC.put("Mother_Nin_Old", String.valueOf("11"));
        MDC.put("DateOfBirth_Old", "06-MAY");
        MDC.put("Person_Fname_Old", "HA");
        MDC.put("Father_Nin_New", "11");
        MDC.put("Mother_Nin_New", "11");
        MDC.put("DateOfBirth_New", "06-MAY-1");
        MDC.put("Person_Fname_New", "KJS");
        MDC.put("UserID", "111");
        MDC.put("exception", "");
        MDC.put("Person_Nin", "11");
        MDC.put("Office_Code", "11");
        loggerSl4j.info("sl4j");
        loggerSl4j2.info("sl4j2");

        ThreadContext.put("Father_Nin_Old", String.valueOf("11"));
        ThreadContext.put("Mother_Nin_Old", String.valueOf("11"));
        ThreadContext.put("DateOfBirth_Old", "06-MAY");
        ThreadContext.put("Person_Fname_Old", "HA");
        ThreadContext.put("Father_Nin_New", "11111");
        ThreadContext.put("Mother_Nin_New", "11111");
        ThreadContext.put("DateOfBirth_New", "06-MAY-1");
        ThreadContext.put("Person_Fname_New", "KJS");
        ThreadContext.put("UserID", "111");
        ThreadContext.put("exception", "");
        ThreadContext.put("Person_Nin", "11");
        ThreadContext.put("Office_Code", "11");

        logger.info("rootLogger");
        logger2.info("logger");

        AppLogger appLogger = new AppLogger("com.mkyong.common.action");
        MDC.put("Father_Nin_Old", String.valueOf("11"));
        MDC.put("Mother_Nin_Old", String.valueOf("11"));
        MDC.put("DateOfBirth_Old", "06-MA");
        MDC.put("Person_Fname_Old", "HA");
        MDC.put("Father_Nin_New", "11");
        MDC.put("Mother_Nin_New", "111");
        MDC.put("DateOfBirth_New", "06-MAY-1");
        MDC.put("Person_Fname_New", "KJS");
        MDC.put("UserID", "111");
        MDC.put("exception", "");
        MDC.put("Person_Nin", "11");
        MDC.put("Office_Code", "11");
        appLogger.defaultLogger.info("Update Iranian");

        return mapping.findForward("success");

    }

}