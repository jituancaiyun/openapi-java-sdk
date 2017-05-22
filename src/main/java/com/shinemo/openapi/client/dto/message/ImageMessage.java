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
public final class ImageMessage extends IMessage<ImageMessage> {
    private Integer width;
    private Integer height;
    private Boolean isGif;

    public ImageMessage() {
    }

    public ImageMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        return null;
    }

    public Integer getWidth() {
        return width;
    }

    public ImageMessage setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public ImageMessage setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Boolean getGif() {
        return isGif;
    }

    public ImageMessage setGif(Boolean gif) {
        isGif = gif;
        return this;
    }

    @Override
    public byte type() {
        return 2;
    }

    @Override
    public String toString() {
        return "ImageMessage{" +
                "width=" + width +
                ", height=" + height +
                ", isGif=" + isGif +
                '}';
    }
}
