package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
  }

  @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User newUser, @RequestParam String verify) {
        // add form submission handling code here
      String error = "Passwords must match.";
      String email = newUser.getEmail();
      String username = newUser.getUsername();
      model.addAttribute("error", error);
      model.addAttribute("username", username);
      model.addAttribute("email", newUser.getEmail());

        if (newUser.getPassword().equals(verify)) {
            UserData.add(newUser);
            return "user/index";
        }
        else {
            return "user/add";
        }
    }
}
