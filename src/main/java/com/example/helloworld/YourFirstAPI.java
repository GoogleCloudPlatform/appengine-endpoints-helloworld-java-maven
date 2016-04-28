/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.helloworld;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.oauth.OAuthRequestException;

import java.io.IOException;

import javax.inject.Named;

// [START header]
/** An endpoint class we are exposing */
@Api(name = "myApi",
    version = "v1",
    namespace = @ApiNamespace(ownerDomain = "helloworld.example.com",
        ownerName = "helloworld.example.com",
        packagePath = ""))
// [END header]

public class YourFirstAPI {

  // [START hi]
  /** A simple endpoint method that takes a name and says Hi back */
  @ApiMethod(name = "sayHi")
  public MyBean sayHi(@Named("name") String name) {
    MyBean response = new MyBean();
    response.setData("Hi, " + name);

    return response;
  }
  //[END hi]

  // [START hi_user]
  /** A simple endpoint method that takes a name and says Hi back */
  @ApiMethod(name = "sayHiUser")
  public MyBean sayHiUser(@Named("name") String name, User user)
      throws OAuthRequestException, IOException {
    MyBean response = new MyBean();
    response.setData("Hi, " + name + "(" + user.getEmail() + ")");

    return response;
  }
  //[END hi_user]

}
