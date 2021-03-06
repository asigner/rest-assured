/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.restassured.module.mockmvc.http;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MultiValueController {

    @RequestMapping(value = "/multiValueParam", method = {POST, GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String multiValueParam(@RequestParam("list") List<String> listValues) {
        return "{ \"list\" : \"" + StringUtils.join(listValues, ",") + "\" }";
    }

    @RequestMapping(value = "/threeMultiValueParam", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String threeMultiValueParam(@RequestParam("list") List<String> list1Values,
                                                     @RequestParam("list2") List<String> list2Values,
                                                     @RequestParam("list3") List<String> list3Values) {
        return "{ \"list\" : \"" + StringUtils.join(list1Values, ",") + "\"," +
                " \"list2\" : \"" + StringUtils.join(list2Values, ",") + "\", " +
                " \"list3\" : \"" + StringUtils.join(list3Values, ",") + "\" }";
    }
}