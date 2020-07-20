package com.garage.web.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.web.backend.form.LoginForm;

@Controller
public class LoginController {

//    @Autowired
//    private UserService userService;

    @GetMapping("/login")
    @AllowAnonymous
    public String home(LoginForm loginForm, Model model) {

        model.addAttribute("form", loginForm);

        return "login/index";
    }

    @PostMapping("/doLogin")
    @AllowAnonymous
    public String doLogin(LoginForm loginForm, Model model, HttpServletRequest request) {

        model.addAttribute("form", loginForm);

//        User user = userService.checkLogin(loginForm.getUsername(),
//                loginForm.getPassword(),
//                NumberUtils.createLong(loginForm.getCompany()));
//
//        if (user == null) {
//            model.addAttribute("messsage", "Tên đăng nhập, mật khẩu hoặc công ty không đúng.");
//            model.addAttribute("companyList", companyService.findByStatus(1L));
//
//            return "login/index";
//        }
//
//        if (user.getStatus().compareTo(0L) == 0) {
//            model.addAttribute("messsage", "Tài khoản của đã bị khóa.");
//            model.addAttribute("companyList", companyService.findByStatus(1L));
//
//            return "login/index";
//        }
//
//        request.getSession(true).setAttribute(WebConsts.USER_ID, user.getUserId());
//        request.getSession(true).setAttribute(WebConsts.FULL_NAME, user.getFullName());
//        request.getSession(true).setAttribute(WebConsts.EMAIL, user.getEmail());
//        request.getSession(true).setAttribute(WebConsts.COMPANY, user.getCompany());
//
//        List<UserPermission> userPermissionList = userPermissionService.findAllWithUserGroup(user.getUserGroup());
//
//        List<String> permissionList = new ArrayList<>();
//        userPermissionList.stream().forEach(v -> {
//            permissionList.add(v.getModule().getModuleUrl());
//        });
//
//        request.getSession(true).setAttribute(WebConsts.USER_PERMISSION, permissionList);

        return "redirect:" + loginForm.getReturnPath();
    }
}
