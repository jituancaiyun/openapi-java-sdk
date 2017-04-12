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
public final class VoteMessage extends IMessage<VoteMessage> {

    private String voteId;
    private String time;

    public VoteMessage() {
    }

    public VoteMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (voteId == null) return "VoteMessage.voteId 不能为空";
        if (time == null) return "VoteMessage.time 不能为空";
        return null;
    }

    public String getVoteId() {
        return voteId;
    }

    public VoteMessage setVoteId(String voteId) {
        this.voteId = voteId;
        return this;
    }

    public String getTime() {
        return time;
    }

    public VoteMessage setTime(String time) {
        this.time = time;
        return this;
    }

    @Override
    public byte type() {
        return 6;
    }
}
