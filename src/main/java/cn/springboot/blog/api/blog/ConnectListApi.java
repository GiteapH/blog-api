package cn.springboot.blog.api.blog;

import java.util.*;

import cn.springboot.blog.entity.ConnectAndUser;
import cn.springboot.blog.service.ConnectListService;
import cn.springboot.blog.util.PageQueryUtil;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1", tags = "联系列表相关接口")
@RequestMapping("/api/v1")
public class ConnectListApi {
    @Autowired
    ConnectListService connectListService;

    @GetMapping("/connectList/getConnectList")
    public Result getConnectList(@RequestParam(required = false,defaultValue = "connect_date") @ApiParam(value = "排序依据") String orderName,
                                 @RequestParam(required = false,defaultValue = "15") @ApiParam(value = "行数") Integer limit,
                                 @RequestParam(required = false,defaultValue = "1") @ApiParam(value = "页码") Integer pageNumber,
                                 @RequestParam @ApiParam(value = "主id") Integer principal
                                ){
        Map<String,Object> map = new HashMap<>();
        map.put("principal",principal);
        map.put("page",pageNumber);
        map.put("limit",limit);
        map.put("orderName",orderName);
        List<ConnectAndUser> connectList;
        Integer len;
        Map<String,Object> resp;
        try {
            resp = new HashMap<>();
            connectList = connectListService.getConnectList(new PageQueryUtil(map));
            len = connectListService.selectAllLenByPrincipal(principal);
            resp.put("list",connectList);
            resp.put("size",len);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult(resp);
    }
}
