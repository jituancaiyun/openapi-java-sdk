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

package com.shinemo.openapi.client.dto.personalremind;

import com.shinemo.openapi.client.dto.CreateUserDTO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ohun on 2017/3/22.
 *
 * @author ohun@live.cn (夜色)
 */
public class PersonalRemindInfoDTO implements Serializable {

    private CreateUserDTO createUser;
    private PersonalRemindDTO personalRemind;

    public CreateUserDTO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(CreateUserDTO createUser) {
        this.createUser = createUser;
    }

    public PersonalRemindDTO getPersonalRemind() {
        return personalRemind;
    }

    public void setPersonalRemind(PersonalRemindDTO personalRemind) {
        this.personalRemind = personalRemind;
    }

    @Override
    public String toString() {
        return "PersonalRemindInfoDTO{" +
                "createUser=" + createUser +
                ", personalRemind=" + personalRemind +
                '}';
    }

}
