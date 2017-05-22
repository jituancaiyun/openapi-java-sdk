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
public final class FileMessage extends IMessage<FileMessage> {
    private String fileId;
    private Integer fileSize;
    private String userId;
    private String downloadUrl;
    private String orgId;

    public FileMessage() {
    }

    public FileMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (fileId == null) return "FileMessage.fileId 不能为空";
        if (userId == null) return "FileMessage.userId 不能为空";
        if (downloadUrl == null) return "FileMessage.downloadUrl 不能为空";
        return null;
    }

    public String getFileId() {
        return fileId;
    }

    public FileMessage setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public FileMessage setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public FileMessage setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public FileMessage setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public FileMessage setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    @Override
    public byte type() {
        return 5;
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "fileId='" + fileId + '\'' +
                ", fileSize=" + fileSize +
                ", userId='" + userId + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", orgId='" + orgId + '\'' +
                '}';
    }
}
