package controller;



import security.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/login")
public class AuthController {
    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        // In a real-world app, you would authenticate the user against the database here.
        if ("user".equals(username) && "password".equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            return "Invalid username or password";
        }
    }
}
