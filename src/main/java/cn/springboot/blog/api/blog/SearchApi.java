package cn.springboot.blog.api.blog;

import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.service.ArticleService;
import cn.springboot.blog.service.CommentsService;
import cn.springboot.blog.service.DynamicService;
import cn.springboot.blog.service.SearchService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "v1", tags = "搜索操作相关接口")
@RequestMapping("/api/v1")
public class SearchApi {
    @Autowired
    SearchService searchService;

    @Autowired
    DynamicService dynamicService;
    @GetMapping("/search/info")
    public Result getSearch(@RequestParam(defaultValue = "") String prefix){
        return ResultGenerator.genSuccessResult(searchService.getSearchSentence(prefix));
    }
}
