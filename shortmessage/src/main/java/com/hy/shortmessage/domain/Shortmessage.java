package com.hy.shortmessage.domain;

import com.hy.shortmessage.util.FastJsonUtils;

import java.util.Date;
 
public class Shortmessage implements java.io.Serializable{
    private static final long serialVersionUID = -1654280046914798917L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 短标识
     */
    private String shortKey;

    /**
     * 原始连接
     */
    private String originalUrl;

    /**
     * 业务类型1上上签发送短信连接,2小程序生成二维码参数
     */
    private Integer biz;


    /**
     * 
     */
    private Date createtime;

    /**
     * 超期时间
     */
    private Date expireTime;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 短标识
     * @return short_key 短标识
     */
    public String getShortKey() {
        return shortKey;
    }

    /**
     * 短标识
     * @param shortKey 短标识
     */
    public void setShortKey(String shortKey) {
        this.shortKey = shortKey == null ? null : shortKey.trim();
    }

    /**
     * 原始连接
     * @return original_url 原始连接
     */
    public String getOriginalUrl() {
        return originalUrl;
    }

    /**
     * 原始连接
     * @param originalUrl 原始连接
     */
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl == null ? null : originalUrl.trim();
    }

    /**
     * 业务类型1上上签发送短信连接
     * @return biz 业务类型1上上签发送短信连接
     */
    public Integer getBiz() {
        return biz;
    }

    /**
     * 业务类型1上上签发送短信连接
     * @param biz 业务类型1上上签发送短信连接
     */
    public void setBiz(Integer biz) {
        this.biz = biz;
    }



    /**
     * 
     * @return createtime 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     * @param createtime 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 超期时间
     * @return expire_time 超期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 超期时间
     * @param expireTime 超期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public static void main(String args[]){
        Shortmessage s=new Shortmessage();
        s.setOriginalUrl("https://t.bestsign.info/9udU/2ND4/F3y1");
        String json=FastJsonUtils.getBeanToJson(s);
        System.out.println(json);
    }

}