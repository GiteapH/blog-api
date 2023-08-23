package cn.springboot.blog.entity;

import java.io.Serializable;

public class UserModules implements Serializable {
    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 开启的模块
     * 1 收藏
     * 2 关注
     * 3 发布
     * 4 打卡
     * 逗号分隔
     *
     * @mbg.generated
     */
    private String openModules;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenModules() {
        return openModules;
    }

    public void setOpenModules(String openModules) {
        this.openModules = openModules;
    }

    public UserModules(Integer uid){
        this.uid = uid;
    }

    public UserModules(){

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", openModules=").append(openModules);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}