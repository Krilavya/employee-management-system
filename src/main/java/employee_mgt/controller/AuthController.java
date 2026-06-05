package employee_mgt.controller;

import employee_mgt.dto.LoginRequest;
import employee_mgt.dto.LoginResponse;
import employee_mgt.dto.RegisterRequest;
import employee_mgt.entity.User;
import employee_mgt.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder){
        this.userService =userService;
        //e line manaki una password ni encrypt chesthadi  and nenu GetAMpping kuda rasanu encrypt kosam adi kuda chudli
        this.passwordEncoder =passwordEncoder;
    }
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }
    @GetMapping("/encrypt/{password}")
    public String encryptPassword(
            @PathVariable String password){
        return passwordEncoder.encode(password);
    }
    @PostMapping("/encryt-all")
    public String encryptAllUsers(){
        userService.encryptExistingUsers();
        return "All Users Encrypted";
    }
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request){
        String token = userService.login(request);
        return new LoginResponse(token);
    }
}
