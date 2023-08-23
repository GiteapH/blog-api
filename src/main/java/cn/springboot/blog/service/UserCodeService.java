package cn.springboot.blog.service;


public interface UserCodeService {
    boolean insertUserCode(String code,String email);

    int checkCode(String code,String email);
}
