package com.bbs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BBSUtil {

    public static String getNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        return format;
    }


}
