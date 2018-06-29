package com.shinemo.openapi.client.dto.message;

import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.dto.action.Action;

import java.util.List;


/**
 * DateTime 2018/6/27
 *
 * @author chengxiao
 */
public class OaMessage extends IMessage<OaMessage> {

    /**
     * 图标
     */
    private String icon;

    /**
     * 标题
     */
    private String title;

    /**
     * 主题
     */
    private String subject;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 主图
     */
    private String image;

    /**
     * 属性
     */
    private List<OaProperties> properties;

    /**
     * 附件
     */
    private String attachment;

    /**
     * 响应地址
     */
    private String action;

    /**
     * 配置
     */
    private Config config;

    public OaMessage(){

    }

    public OaMessage(String message){
        super(message);
    }

    @Override
    protected byte type() {
        return 39;
    }

    @Override
    public String validate() {
        if (subject == null) return "OaMessage.subject 不能为空";
        return null;
    }

    public String getIcon() {
        return icon;
    }

    public OaMessage setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public OaMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public OaMessage setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public OaMessage setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getImage() {
        return image;
    }

    public OaMessage setImage(String image) {
        this.image = image;
        return this;
    }

    public List<OaProperties> getProperties() {
        return properties;
    }

    public OaMessage setProperties(List<OaProperties> properties) {
        this.properties = properties;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public OaMessage setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public String getAction() {
        return action;
    }

    public OaMessage setAction(String action) {
        this.action = action;
        return this;
    }

    public Config getConfig() {
        return config;
    }

    public OaMessage setConfig(Config config) {
        this.config = config;
        return this;
    }

    public OaMessage setUrlAction(String url) {
        return setUrlAction(url, null);
    }

    public OaMessage setUrlAction(String url, String param) {
        if (config == null) throw new OpenApiException("OaMessage.config 不能为空");
        if (config.appId == null) throw new OpenApiException("config.appId 不能为空");
        if (config.orgId == null) throw new OpenApiException("config.orgId 不能为空");
        if (url == null) throw new OpenApiException("url 不能为空");

        Action.ActionData actionData = new Action.OpenUrlActionData(url, param,config.appId,config.orgId);
        return this.setAction(new Action("native", "openurl", actionData).toAction());
    }

    @Override
    public String toString() {
        return "OaMessage{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", summary='" + summary + '\'' +
                ", image='" + image + '\'' +
                ", properties=" + properties +
                ", attachment='" + attachment + '\'' +
                ", action='" + action + '\'' +
                ", config=" + config +
                '}';
    }



    /**
     * 配置相关对象
     */
    public static class Config{
        /**
         * 应用ID
         */
        private Integer appId;

        /**
         * 企业ID
         */
        private Long orgId;

        /**
         * 未读数
         */
        private Integer unreadCount;

        public Integer getAppId() {
            return appId;
        }

        public void setAppId(Integer appId) {
            this.appId = appId;
        }

        public Long getOrgId() {
            return orgId;
        }

        public void setOrgId(Long orgId) {
            this.orgId = orgId;
        }

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
        }

        @Override
        public String toString() {
            return "Config{" +
                    "appId=" + appId +
                    ", orgId=" + orgId +
                    ", unreadCount=" + unreadCount +
                    '}';
        }
    }

    public static class OaProperties {
        private String key;
        private String value;

        public OaProperties() {
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "OaProperties{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
