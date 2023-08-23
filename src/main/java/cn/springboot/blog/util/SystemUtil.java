package cn.springboot.blog.util;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;


public class SystemUtil {

    private SystemUtil() {
    }


    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     *
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    public static String genToken(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }


//    点赞收藏需要的字段
    /**
    *@author 吕杨平
    *@Description "like","dislike","collected","comments","watched"
    *@Date 19:15 2023/2/10
    *@Param [i]
    *@Return java.lang.String
    */
    public static String getParamName(int i){
        String[] names = new String[]{"like","dislike","collected","comments","watched"};
        return names[i];
    }


//    用户个人中心模块
    /**
    *@author 吕杨平
    *@Description "收藏列表","关注列表","发布列表","发布数量打卡"
    *@Date 19:15 2023/2/10
    *@Param [i]
    *@Return java.lang.String
    */
    public static String getModuleName(int i){
        String[] names = new String[]{"收藏列表","关注列表","发布列表","发布数量打卡","粉丝列表"};
        return names[i];
    }
    //    用户个人中心模块
    /**
    *@author 吕杨平
    *@Description "收藏列表","关注列表","发布列表","发布数量打卡"
    *@Date 19:15 2023/2/10
    *@Param []
    *@Return java.lang.String[]
    */
    public static String[] getModuleNames(){
        return new String[]{"收藏列表","关注列表","发布列表","发布数量打卡","粉丝列表"};

    }

//    获取评论排序字段
    /**
    *@author 吕杨平
    *@Description "like","watched","comments","collected"
    *@Date 19:15 2023/2/10
    *@Param [i]
    *@Return java.lang.String
    */
    public static String getOrderName(int i){
        String[] names = new String[]{"like,watched,comments","like","collected","watched","comments","date"};
        return names[i];
    }

    //    获取用户排序字段
    /**
     *@author 吕杨平
     *@Description "like","watched","comments","collected"
     *@Date 19:15 2023/2/10
     *@Param [i]
     *@Return java.lang.String
     */
    public static String getUserOrderName(int i){
        String[] names = new String[]{"fans","readers","submits","interviewer","goods","createTime"};
        return names[i];
    }

    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        //判断文件存不存在
        if(!file.exists()){
            System.out.println("删除文件失败："+fileName+"不存在！");
            return false;
        }else{
            //判断这是不是一个文件，ps：有可能是文件夹
            if(file.isFile()){
                return file.delete();
            }
        }
        return false;
    }
}
