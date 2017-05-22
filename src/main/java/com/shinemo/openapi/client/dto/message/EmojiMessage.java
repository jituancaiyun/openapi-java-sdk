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
public final class EmojiMessage extends IMessage<EmojiMessage> {

    private String md5;
    private String gitMd5;

    public EmojiMessage() {
    }

    public EmojiMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (md5 == null) return "EmojiMessage.md5 不能为空";
        return null;
    }

    public String getMd5() {
        return md5;
    }

    public EmojiMessage setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public String getGitMd5() {
        return gitMd5;
    }

    public EmojiMessage setGitMd5(String gitMd5) {
        this.gitMd5 = gitMd5;
        return this;
    }

    @Override
    public byte type() {
        return 12;
    }

    @Override
    public String toString() {
        return "EmojiMessage{" +
                "md5='" + md5 + '\'' +
                ", gitMd5='" + gitMd5 + '\'' +
                '}';
    }
}
