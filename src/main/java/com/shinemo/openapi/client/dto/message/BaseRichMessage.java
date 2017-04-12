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

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
@SuppressWarnings("unchecked")
public abstract class BaseRichMessage<T extends BaseRichMessage> extends IMessage<T> {
    private String content;
    private String url;
    private String image;
    private String from;
    private String fromIcon;

    public BaseRichMessage() {
    }

    public BaseRichMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (content == null) return "RichMessage.content 不能为空";
        if (url == null && image == null) return "RichMessage.url或RichMessage.image 不能为空";
        return null;
    }

    public String getContent() {
        return content;
    }

    public T setContent(String content) {
        this.content = content;
        return (T) this;
    }

    public String getUrl() {
        return url;
    }

    public T setUrl(String url) {
        this.url = url;
        return (T) this;
    }

    public String getImage() {
        return image;
    }

    public T setImage(String image) {
        this.image = image;
        return (T) this;
    }

    public String getFrom() {
        return from;
    }

    public T setFrom(String from) {
        this.from = from;
        return (T) this;
    }

    public String getFromIcon() {
        return fromIcon;
    }

    public T setFromIcon(String fromIcon) {
        this.fromIcon = fromIcon;
        return (T) this;
    }
}
