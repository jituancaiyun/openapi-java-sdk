package com.shinemo.openapi.client;

/**
 * @author yuanjian
 * date 2/27/18
 * email liuyj@shinemo.com
 */
public interface Constants {

    enum OrgSecret {

        DAILY_SECRET("AQADAAAAAAAAAMqvsE8NAAAA"),
        ONLINE_SECRET("");

        public final String orgSecret;

        OrgSecret(String orgSecret) {
            this.orgSecret = orgSecret;
        }

    }


}
