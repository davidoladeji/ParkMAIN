package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.model.Gender;
import com.davidoladeji.park.model.Role;
import com.davidoladeji.park.service.implementation.AccountServiceImpl;
import com.davidoladeji.park.service.implementation.GenderServiceImpl;
import com.davidoladeji.park.service.implementation.RoleServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * This controller takes care of User
 * CRUD for Admin Users
 */


@Controller
public class UserController {

    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    GenderServiceImpl genderService;
    @Autowired
    AccountServiceImpl accountService;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) {

        List<Account> allAccounts = accountService.findAllAccounts();

        model.addObject("userx", allAccounts);
        int numUsers = allAccounts.size();

        model.addObject("numUsers", numUsers);

        model.setViewName("admin/users");
        return model;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (Account account : accountService.findAllAccounts()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", account.getId());
            userJSON.put("firstName", account.getFirstName());
            userJSON.put("lastName", account.getLastName());
            userJSON.put("email", account.getEmail());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }


    @RequestMapping(value = "admin/users/addPage", method = RequestMethod.GET)
    public ModelAndView addUserPage(ModelAndView model) {


        model.addObject("user", new Account());

        List<Role> allRoles = roleService.findAllRoles();
        model.addObject("rolex", allRoles);

        List<Gender> allGenders = genderService.findAllGenders();
        model.addObject("genderx", allGenders);

        model.setViewName("/admin/addUser");
        return model;
    }

    @RequestMapping(value = "/admin/users/addPage/add/", method = RequestMethod.POST)
    public ModelAndView addUserAction(ModelAndView model, @Valid @ModelAttribute("user") Account account, BindingResult result) {

        if (result.hasErrors()) {

            model.setViewName("redirect://admin/addUser");
            return model;
        } else {
            accountService.createAccount(account);
            model.setViewName("redirect://admin/users");
            return model;
        }


    }


    @RequestMapping(value = "admin/users/editPage/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(ModelAndView model, @PathVariable("id") Long id) {

        List<Role> allRoles = roleService.findAllRoles();
        model.addObject("rolex", allRoles);

        List<Gender> allGenders = genderService.findAllGenders();
        model.addObject("genderx", allGenders);


        Account account = accountService.findAccountById(id);
        model.addObject("user", account);

        model.setViewName("/admin/editUser");
        return model;
    }


    @RequestMapping(value = "/admin/users/editPage", method = RequestMethod.POST)
    public ModelAndView editUserAction(ModelAndView model, @Valid @ModelAttribute("user") Account account, BindingResult result, @RequestParam("id") Long id) {

        if (result.hasErrors()) {

            model.setViewName("/admin/editUser");
            return model;
        } else {
            accountService.updateAccountById(id);
            model.setViewName("/admin/users");
            return model;
        }


    }

    @RequestMapping(value = "/admin/users/delete/{id}")
    public ModelAndView deleteUser(ModelAndView model, @PathVariable("id") Long id) {
        accountService.deleteAccountById(id);
        model.setViewName("redirect:/admin/users/");
        return model;

    }

}