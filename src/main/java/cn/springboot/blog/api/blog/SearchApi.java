package cn.springboot.blog.api.blog;

import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.entity.SearchContent;
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

    @PostMapping("/search/updateHot")
    public Result updateHot(@RequestBody SearchContent searchContent){
//        是否已存在搜索的
        SearchContent content = searchService.getSearchContent(searchContent.getSearchContent());
        if(content!=null){
            content.setPriority(content.getPriority()+1);
            int i = searchService.updateSearchSentence(content);
            if(i!=0){
                return ResultGenerator.genSuccessResult("操作成功");
            }else{
                return ResultGenerator.genSuccessResult("操作失败");
            }
        }else{
            int i = searchService.insertSearchSentence(new SearchContent(searchContent.getSearchContent()));
            if(i!=0){
                return ResultGenerator.genSuccessResult("操作成功");
            }else{
                return ResultGenerator.genSuccessResult("操作失败");
            }
        }
    }
}
