package com.shinemo.openapi.client.dto;

import java.util.List;

public class AppMessageDTO {

    private String appId;

    private String msgType;

    private MsgBody msgBody;

    private List<String> receivers;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public MsgBody getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        this.msgBody = msgBody;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public static class MsgBody {

        private String content;

        private String picUrl;

        private String mediaId;

        private Integer width;

        private Integer height;

        private Integer articleCount;

        private List<Article> articles;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getArticleCount() {
            return articleCount;
        }

        public void setArticleCount(Integer articleCount) {
            this.articleCount = articleCount;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

        public static class Article {

            private String title;

            private String description;

            private String picUrl;

            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "Article{" +
                        "title='" + title + '\'' +
                        ", description='" + description + '\'' +
                        ", picUrl='" + picUrl + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "MsgBody{" +
                    "content='" + content + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", mediaId='" + mediaId + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", articleCount=" + articleCount +
                    ", articles=" + articles +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppMessageDTO{" +
                "appId='" + appId + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgBody=" + msgBody +
                ", receivers=" + receivers +
                '}';
    }

    public static class Receiver {

        private String uid;

        public Receiver() {
            super();
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}




