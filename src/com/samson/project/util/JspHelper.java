package com.samson.project.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {
    public static final String JSP_FORMAT="/WEB-INF/jsp/%s.jsp";
    public static String getPath(String jspName){
        return String.format(JSP_FORMAT,jspName);
    }
}
