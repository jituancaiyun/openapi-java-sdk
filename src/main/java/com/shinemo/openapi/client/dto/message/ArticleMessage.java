/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.dto.message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class ArticleMessage extends IMessage<ArticleMessage> {
    private int articleCount;
    private List<Article> articles;

    public ArticleMessage() {
    }

    public ArticleMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (articleCount <= 0) return "ArticleMessage.articleCount 必须大于0";
        if (articles == null || articles.isEmpty()) return "ArticleMessage.articles 不能为空";
        return null;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public ArticleMessage setArticleCount(int articleCount) {
        this.articleCount = articleCount;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public ArticleMessage setArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    public ArticleMessage addArticle(String title, String description, String picUrl, String url) {
        if (articles == null) {
            articles = new ArrayList<Article>();
        }
        articles.add(new Article(title, description, picUrl, url));
        articleCount = articles.size();
        return this;
    }

    @Override
    public byte type() {
        return 20;
    }


    public static class Article {
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public Article() {
        }

        public Article(String title, String description, String picUrl, String url) {
            this.title = title;
            this.description = description;
            this.picUrl = picUrl;
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public Article setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Article setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public Article setPicUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Article setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
