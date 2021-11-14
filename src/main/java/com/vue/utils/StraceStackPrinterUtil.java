package com.vue.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: shaok
 * @Date: Created in  2020/10/21 3:55 下午
 * @Description: 打印错误堆栈
 */
public class StraceStackPrinterUtil {

    public static String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
