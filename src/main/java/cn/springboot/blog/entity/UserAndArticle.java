package cn.springboot.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

@Data
public class UserAndArticle implements Serializable {
    /**
     * 上传者id
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     * 文章id
     *
     * @mbg.generated
     */
    private Integer aid;

    /**
     * 发布日期
     *
     * @mbg.generated
     */
    private Date date;

    /**
     * 点赞数
     *
     * @mbg.generated
     */
    private String like;

    /**
     * 评论数
     *
     * @mbg.generated
     */
    private Integer comments;

    /**
     * 观看数
     *
     * @mbg.generated
     */
    private Integer watched;

    /**
     * 收藏数
     *
     * @mbg.generated
     */
    private String collected;

    /**
     * 文章标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 文章内容
     *
     * @mbg.generated
     */
    private String articles;

    /**
     * 文章类别，用户自定义
     *
     * @mbg.generated
     */
    private String classper;

    /**
     * 文章类别，系统定义
     *
     * @mbg.generated
     */
    private String classsys;

    /**
     * 简介
     *
     * @mbg.generated
     */
    private String tinymes;

    private Long id;

    private String email;

    private String username;

    private String password;

    private String head;

    private String cardimg;

    private Byte lockedflag;

    private Byte isdeleted;

    private Date createtime;

    private String describe;


    private List<ArticlePointsCount> countType;

    private Map<Integer,List<Integer>> typeUidsMap;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg;
    }

    public Byte getLockedflag() {
        return lockedflag;
    }

    public void setLockedflag(Byte lockedflag) {
        this.lockedflag = lockedflag;
    }

    public Byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getWatched() {
        return watched;
    }

    public void setWatched(Integer watched) {
        this.watched = watched;
    }

    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    public String getClassper() {
        return classper;
    }

    public void setClassper(String classper) {
        this.classper = classper;
    }

    public String getClasssys() {
        return classsys;
    }

    public void setClasssys(String classsys) {
        this.classsys = classsys;
    }

    public String getTinymes() {
        return tinymes;
    }

    public void setTinymes(String tinymes) {
        this.tinymes = tinymes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", aid=").append(aid);
        sb.append(", date=").append(date);
        sb.append(", like=").append(like);
        sb.append(", comments=").append(comments);
        sb.append(", watched=").append(watched);
        sb.append(", collected=").append(collected);
        sb.append(", title=").append(title);
        sb.append(", articles=").append(articles);
        sb.append(", classper=").append(classper);
        sb.append(", classsys=").append(classsys);
        sb.append(", tinymes=").append(tinymes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", head=").append(head);
        sb.append(", cardimg=").append(cardimg);
        sb.append(", lockedflag=").append(lockedflag);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", createtime=").append(createtime);
        sb.append(", describe=").append(describe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
