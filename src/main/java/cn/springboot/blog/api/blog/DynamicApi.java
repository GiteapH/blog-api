package cn.springboot.blog.api.blog;

import cn.springboot.blog.api.blog.param.DynamicParams;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.service.DynamicService;
import cn.springboot.blog.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(value = "v1", tags = "动态相关接口")
@RequestMapping("/api/v1")
public class DynamicApi {
    @Autowired
    DynamicService dynamicService;

    @GetMapping("/dynamic/getDynamicInfo")
    public Result getDynamicInfo(@RequestParam(required = false) Integer uid,@RequestParam(defaultValue = "-1") Integer type,
                                 @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "15") Integer limit){
        Map<String,Object> store = new HashMap<>();
        store.put("page",page);
        store.put("limit",limit);
        store.put("uid", uid);
        store.put("type",type);
        List<Map<String, Object>> dynamicInfo = null;
        try {
            dynamicInfo = dynamicService.getDynamicInfo(new PageQueryUtil(store));
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }

        return ResultGenerator.genSuccessResult(dynamicInfo);

    }


    @PutMapping("/dynamic/sendDynamic")
    public Result sendDynamic(@RequestBody DynamicParams dynamicParams){
        System.err.println(dynamicParams);
        Dynamic dynamic = new Dynamic();
        dynamic = (Dynamic)BeanUtil.copyProperties(dynamicParams, dynamic);
        try{
            int i = dynamicService.insertDynamic(dynamic);
            if(i>0){
                return ResultGenerator.genSuccessResult(dynamic);
            }else{
                return ResultGenerator.genFailResult("发表失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }

    }
}
