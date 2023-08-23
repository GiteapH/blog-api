package cn.springboot.blog.service.impl;

import cn.springboot.blog.dao.UserCodeMapper;
import cn.springboot.blog.entity.UserCode;
import cn.springboot.blog.service.UserCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserCodeServiceImpl implements UserCodeService {
    @Autowired
    UserCodeMapper userCodeMapper;

    @Override
    public boolean insertUserCode(String code, String email) {
        long now = new Date().getTime();
//        五小时过期
        Date expire_date = new Date(now+5*60*60*1000);

//       验证码已存在，更新过期日期和更新日期
        UserCode userCode = userCodeMapper.selectByPrimaryKey(email);
        if(userCode!=null){
            int effect = userCodeMapper.updateByPrimaryKeySelective(new UserCode(expire_date, new Date(now),email,code));
            return effect != 0;
        }else{
            int effect = userCodeMapper.insertSelective(new UserCode(expire_date, new Date(now), email, code));
            return effect != 0;
        }
    }

    @Override
    public int checkCode(String code,String email) {
        UserCode userCode = userCodeMapper.selectByPrimaryKey(email);
        Date now = new Date();
        if(userCode==null)return -1;
        if(!now.before(userCode.getExpireTime()))return 2;
        if(userCode.getCode().equals(code)){
//            删除记录
            userCodeMapper.deleteByPrimaryKey(email);
            return 1;
        }
        return 0;
    }
}
