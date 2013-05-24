package com.github.springmvcjapid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/foo")
public class TestController {
	@RequestMapping(method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
    public String get() {
        return "{\"name\":\"Lee\"}";
    }
}
