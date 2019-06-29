package com.ecomerce.Controller;


import com.ecomerce.Model.Homepage;
import com.ecomerce.Model.Product;
import com.ecomerce.Model.User;
import com.ecomerce.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("user")
@Controller
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MainService mainService;

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/")
    public String home(Authentication authentication, Model model) {
        User u = new User();
        Homepage h = new Homepage();
        if (authentication != null) {
            u = mainService.findUserByEmail(authentication.getName());
        }
        model.addAttribute("user", u);
        model.addAttribute("categories", mainService.getHomePageProducts(h.getCategorieslist()));
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signuppost(@ModelAttribute("user") User user) {
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAuthority("USER");
            mainService.saveUser(user);
        }
        return "index";
    }

    @GetMapping("/addproduct")
    public String addproduct(Model model) {
        model.addAttribute("product", new Product());

        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String addproducta(@ModelAttribute("product") Product product, @RequestParam String categories, @RequestParam String tags) {


        return "redirect:/";

    }

}
