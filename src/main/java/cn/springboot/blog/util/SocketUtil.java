package cn.springboot.blog.util;

import java.util.*;

public class SocketUtil {
    public static Map<String,Object> getSystemMessageMap(String messageType){
        Map<String,Object> map = new HashMap<>();
        map.put("messageType",messageType);
        return map;
    }
}
