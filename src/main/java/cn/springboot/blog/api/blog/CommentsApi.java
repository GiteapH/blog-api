package cn.springboot.blog.api.blog;

import cn.springboot.blog.entity.CommentAndUser;
import cn.springboot.blog.entity.Comments;
import cn.springboot.blog.entity.Dynamic;
import cn.springboot.blog.service.ArticleService;
import cn.springboot.blog.service.CommentsService;
import cn.springboot.blog.service.DynamicService;
import cn.springboot.blog.util.Result;
import cn.springboot.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "v1", tags = "评论操作相关接口")
@RequestMapping("/api/v1")
public class CommentsApi {
    @Autowired
    CommentsService commentsService;
    @Autowired
    ArticleService articleService;

    @Autowired
    DynamicService dynamicService;
    @GetMapping("/comment/getComments")
    public Result getComments(@RequestParam Integer aid,@RequestParam(defaultValue = "1")Integer cType,@RequestParam(defaultValue = "0") Integer orderColumn){
        List<CommentAndUser> comments = commentsService.getComments(aid,cType,orderColumn);
        if(comments==null){
            return ResultGenerator.genErrorResult(500,"查找失败");
        }
        return ResultGenerator.genSuccessResult(comments);
    }

    @PostMapping("/comment/insertComment")
    public Result insertComment(@RequestBody Comments comments,@RequestParam(defaultValue = "false") Boolean need){
        System.err.println(comments);
        int i = commentsService.insertComments(comments,need);
        int intParams;
        if(i!=0){
//            文章
            if(comments.getCType()==null||comments.getCType()==1) {
                intParams = articleService.updateIntParams(null, "comments", comments.getAid());
                if (intParams != 0) {
                    return ResultGenerator.genSuccessResult();
                }
                return ResultGenerator.genErrorResult(501, "文章评论条数更新失败");
            }
//            动态
            else if (comments.getCType()==2) {
                intParams = dynamicService.updateParams(new Dynamic(1, null,comments.getAid()));
                if (intParams != 0) {
                    return ResultGenerator.genSuccessResult();
                }
                return ResultGenerator.genErrorResult(501, "动态评论条数更新失败");
            }
            return ResultGenerator.genSuccessResult();
        }else{
            return  ResultGenerator.genFailResult("插入失败");
        }
    }

    @GetMapping("/comment/getDetailComments")
    public Result getDetailComments(@RequestParam Integer aid,@RequestParam Integer cid,@RequestParam(defaultValue = "1")Integer cType){
        List<CommentAndUser> comments = commentsService.getDetailComments(aid,cid,cType);
        if(comments==null){
            return ResultGenerator.genErrorResult(500,"查找失败");
        }
        return ResultGenerator.genSuccessResult(comments);
    }
}
