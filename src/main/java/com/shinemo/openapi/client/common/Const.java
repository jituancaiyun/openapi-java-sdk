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

package com.shinemo.openapi.client.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public interface Const {
    Logger LOG = LoggerFactory.getLogger("com.shinemo.openapi.client");

    String USER_AGENT_HEADER_NAME = "user-agent";
    String USER_AGENT_HEADER_VALUE = "open-api-sdk(1.0)";
    String USER_AGENT_HEADER = USER_AGENT_HEADER_NAME + ':' + USER_AGENT_HEADER_VALUE;
    String CONTENT_TYPE_HEADER = "content-type:text/plain; charset=utf-8";

    Charset UTF_8 = Charset.forName("UTF-8");
    Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

}
