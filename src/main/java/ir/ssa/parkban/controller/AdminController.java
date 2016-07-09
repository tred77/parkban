package ir.ssa.parkban.controller;

import ir.ssa.parkban.service.dto.entity.TokenDto;
import ir.ssa.parkban.vertical.configuration.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hadoop on 3/27/16.
 */
@RestController
public class AdminController {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @RequestMapping(value = "/customLogin")
    public ModelAndView customLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("security/login");

        return model;

    }

    @RequestMapping (value = "/desktop")
    public ModelAndView goDesktop(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public TokenDto login(String username,  String password) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = this.userService.loadUserByUsername(username);

        return new TokenDto(TokenUtils.createToken(userDetails));
    }



}
