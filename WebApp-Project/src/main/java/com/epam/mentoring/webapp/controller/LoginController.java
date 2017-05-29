package com.epam.mentoring.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("name", user.getName());
//        map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
//        return map;
    }
}
