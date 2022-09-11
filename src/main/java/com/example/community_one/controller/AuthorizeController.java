package com.example.community_one.controller;

import com.example.community_one.model.User;
import com.example.community_one.dto.AccessTokenDto;
import com.example.community_one.dto.GitHubUser;
import com.example.community_one.mapper.UserMapper;
import com.example.community_one.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

//接收传过来的code和state
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

//    从配置文件中拿用@Value("${配置文件的key值}")
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Value("${github.client.secret}")
    private String clientSecret;


    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);

        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);
       if (gitHubUser!=null){
           User user = new User();
           user.setToken(UUID.randomUUID().toString());
           user.setName(gitHubUser.getName());
           user.setAccountId(String.valueOf(gitHubUser.getId()));
           user.setGmtCreate(System.currentTimeMillis());
           user.setGmtModified(user.getGmtCreate());
           userMapper.insert(user);
//           登录成功，创建cookie和session
           request.getSession().setAttribute("user",gitHubUser);
           return "redirect:/";
       }else {
//           登录失败
           return "redirect:/";
       }

    }
}
