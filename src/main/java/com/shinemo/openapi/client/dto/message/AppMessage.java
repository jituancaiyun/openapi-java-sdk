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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class AppMessage extends IMessage<AppMessage> {
    private String content;
    private String from;
    private String fromIcon;
    private Byte isShare;
    private String action;
    private String title;
    private String preTitle;
    private String color;

    public AppMessage() {
    }

    public AppMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (title == null) return "AppMessage.title 不能为空";
        if (content == null) return "AppMessage.content 不能为空";
        return null;
    }

    public String getContent() {
        return content;
    }

    public AppMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public AppMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getFromIcon() {
        return fromIcon;
    }

    public AppMessage setFromIcon(String fromIcon) {
        this.fromIcon = fromIcon;
        return this;
    }

    public Byte getIsShare() {
        return isShare;
    }

    public AppMessage setIsShare(Byte isShare) {
        this.isShare = isShare;
        return this;
    }

    public String getAction() {
        return action;
    }

    public AppMessage setAction(Action action) {
        this.action = action.toAction();
        return this;
    }

    public AppMessage setUrlAction(int appId, String url, String param) {
        ActionData actionData = new OpenUrlActionData(url, param, appId);
        return this.setAction(new Action("native", "openurl", actionData));
    }

    public String getTitle() {
        return title;
    }

    public AppMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPreTitle() {
        return preTitle;
    }

    public AppMessage setPreTitle(String preTitle) {
        this.preTitle = preTitle;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AppMessage setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public byte type() {
        return 18;
    }


    public static class Action {
        private String scheme;
        private String action;
        private ActionData data;

        public Action() {
        }

        public Action(String scheme, String action, ActionData data) {
            this.scheme = scheme;
            this.action = action;
            this.data = data;
        }


        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public ActionData getData() {
            return data;
        }

        public void setData(ActionData data) {
            this.data = data;
        }


        public String toAction() {
            return scheme + "://" + action + "?data=" + data.toJson();
        }
    }

    public static abstract class ActionData {
        public abstract String toJson();
    }

    public static class OpenUrlActionData extends ActionData {
        private String url;
        private String param;
        private int appid;
        private int token = 1;
        private int cookie = 1;
        private int noDefaultMenu = 0;

        public OpenUrlActionData() {
        }

        public OpenUrlActionData(String url, String param, int appid) {
            this.url = url;
            this.param = param;
            this.appid = appid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public int getAppid() {
            return appid;
        }

        public void setAppid(int appid) {
            this.appid = appid;
        }

        public int getToken() {
            return token;
        }

        public void setToken(int token) {
            this.token = token;
        }

        public int getCookie() {
            return cookie;
        }

        public void setCookie(int cookie) {
            this.cookie = cookie;
        }

        public int getNoDefaultMenu() {
            return noDefaultMenu;
        }

        public void setNoDefaultMenu(int noDefaultMenu) {
            this.noDefaultMenu = noDefaultMenu;
        }

        @Override
        public String toJson() {
            String json = "{\"url\":\"" + url
                    + "\",\"param\":\"" + param
                    + "\",\"appid\":" + appid
                    + ",\"token\":" + token
                    + ",\"cookie\":" + cookie
                    + ",\"noDefaultMenu\":" + noDefaultMenu
                    + "}";
            try {
                return URLEncoder.encode(json, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
            return json;
        }
    }
}
