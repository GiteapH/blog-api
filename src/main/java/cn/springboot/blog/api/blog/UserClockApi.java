package cn.springboot.blog.api.blog;

import cn.springboot.blog.entity.ClockRet;
import cn.springboot.blog.entity.UserClock;
import cn.springboot.blog.service.UserClockService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Api(value = "v1", tags = "用户事件经历相关接口")
@RequestMapping("/api/v1")
public class UserClockApi {
    @Autowired
    UserClockService userClockService;

    @GetMapping("/clock/AllClocks")
    public Result allClocks(@RequestParam Integer uid,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM")Date start,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM")Date end){
        try {
            List<UserClock> userClocks = userClockService.getUserClocks(uid, start, end);
            Map<String,ClockRet> clockRets = new HashMap<>();
            for(UserClock userClock:userClocks){
                String events = userClock.getEvent();
                List<Map<String,Object>> eventsStore = new ArrayList<>();
                for(String item:events.split(",")){
                    String[] eventItem = item.split(" ");
                    Map<String,Object> event_type = new HashMap<>();
                    event_type.put("event",eventItem[0]);
                    event_type.put("type",eventItem[1]);
                    eventsStore.add(event_type);
                }
                SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
                clockRets.put(myFmt.format(userClock.getClockDate()),new ClockRet(eventsStore,userClock.getKid()));
            }
            return ResultGenerator.genSuccessResult(clockRets);
        }  catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}
