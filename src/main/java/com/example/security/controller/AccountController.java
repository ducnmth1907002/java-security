package com.example.security.controller;

import com.example.security.entity.Account;
import com.example.security.entity.Credential;
import com.example.security.serivce.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Credential login(@RequestBody String username, String password) {
        return accountService.login(username, password);
    }
}
