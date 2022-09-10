package com.example.community_one.controller;

import com.example.community_one.dto.AccessTokenDto;
import com.example.community_one.dto.GitHubUser;
import com.example.community_one.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//接收传过来的code和state
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8885/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("Iv1.3bf3e17e5f09748a");
        accessTokenDto.setClient_secret("2c467b012d41206d5a4541559248956879e60fe9");

        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
