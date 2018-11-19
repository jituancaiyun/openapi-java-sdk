package com.shinemo.openapi.client;

/**
 * @author yuanjian
 * date 2/27/18
 * email liuyj@shinemo.com
 */
public interface Constants {

    enum OrgSecret {

        DAILY_SECRET("AQB3AQAAAAAAAKlMAQAAAAAA"),
        ONLINE_SECRET("AQDRAwEAAAAAALjZAgAAAAAA"),
        ZHFL_SECRET("9QOQOAEAAAAAAJA4AQAAAAAA"),
        DUANMATONG_SECRET("BgDS2wAAAAAAAAAQgJvudFgD");

        public final String orgSecret;

        OrgSecret(String orgSecret) {
            this.orgSecret = orgSecret;
        }

    }


}
