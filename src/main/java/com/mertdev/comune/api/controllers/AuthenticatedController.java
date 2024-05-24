package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.responses.AuthenticatedAccountResponse;
import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/authenticated")
@RequiredArgsConstructor
public class AuthenticatedController {
    private final AccountService accountService;
    @GetMapping("")
    public AccountResponse existsAuthentication(){
        log.info("Authenticated!");
        return accountService.getAccountResponse();
    }

}
