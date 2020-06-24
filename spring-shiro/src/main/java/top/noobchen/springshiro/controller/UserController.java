package top.noobchen.springshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "用户名不存在");
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public String add(){
        return "add";
    }


}
