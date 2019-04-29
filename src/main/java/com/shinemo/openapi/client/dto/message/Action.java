package com.shinemo.openapi.client.dto.message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * DateTime 2018/6/27
 *
 * @author chengxiao
 */
public class Action {

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

    public static String buildOpenUrlAction(String url, String param, int appId, long orgId) {
        Action.ActionData actionData = new Action.OpenUrlActionData(url, param, appId, orgId);
        return new Action("native", "openurl", actionData).toAction();
    }


    public static abstract class ActionData {
        public abstract String toJson();
    }

    public static class OpenUrlActionData extends ActionData {
        private String url;
        private String param;
        private int token = 1;
        private int cookie = 0;
        private int noDefaultMenu = 0;
        private Integer appId;
        private Long orgId;

        public OpenUrlActionData() {
        }

        public OpenUrlActionData(String url, String param) {
            this.url = url;
            this.param = param;
        }

        public OpenUrlActionData(String url, String param, Integer appId, Long orgId) {
            this.url = url;
            this.param = param;
            this.appId = appId;
            this.orgId = orgId;
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

        @Override
        public String toJson() {
            String json = "{\"url\":\"" + url
                    + "\",\"param\":\"" + (param == null || param.isEmpty() ? ("orgid=" + orgId) : (param + "&orgid=" + orgId))
                    + "\",\"appid\":" + appId
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
