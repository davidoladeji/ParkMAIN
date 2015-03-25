package com.davidoladeji.park.controller;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.model.Gender;
import com.davidoladeji.park.model.Role;
import com.davidoladeji.park.service.interfaces.AccountService;
import com.davidoladeji.park.service.interfaces.GenderService;
import com.davidoladeji.park.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * This controller takes care of User
 * CRUD for Frontend User profile
 */


@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    GenderService genderService;


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView viewProfile(ModelAndView modell) {


        modell.setViewName("profile");
        return modell;
    }

    @RequestMapping(value = "/profile/register", method = RequestMethod.GET)
    public String addUserPage(ModelMap modell) {


        modell.addAttribute("user", new Account());

        List<Role> allRoles = roleService.findAllRoles();
        modell.addAttribute("rolex", allRoles);

        List<Gender> allGenders = genderService.findAllGenders();
        modell.addAttribute("genderx", allGenders);


        return "login";
    }

    @RequestMapping(value = "/profile/register/add", method = RequestMethod.POST)
    public ModelAndView registerAccount(@Valid @ModelAttribute("user") Account account, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            String referer = request.getHeader("Referer");
            return new ModelAndView(new RedirectView("redirect:" + referer));
        } else {

            accountService.createAccount(account);

            return new ModelAndView(new RedirectView("redirect:/admin/users"));
        }

    }

    @RequestMapping("/delete/{myId}")
    public String deleteAccount(@PathVariable("myId") Long id) {
        accountService.deleteAccountById(id);
        return "redirect:/profile/";
    }
}