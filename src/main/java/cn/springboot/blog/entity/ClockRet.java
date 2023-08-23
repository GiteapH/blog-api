package cn.springboot.blog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class ClockRet {

//    储存事件集合
    List<Map<String,Object>> events = new ArrayList<>();


//    事件id
    Integer kid;

    public ClockRet(List<Map<String, Object>> events, Integer kid){
        this.events = events;
        this.kid = kid;
    }
}
