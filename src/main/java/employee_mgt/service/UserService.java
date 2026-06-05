package employee_mgt.service;
import employee_mgt.dto.LoginRequest;
import employee_mgt.dto.RegisterRequest;
import employee_mgt.entity.User;
import employee_mgt.repository.UserRepository;
import employee_mgt.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;
        public UserService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder =passwordEncoder;
        }
             public User register(RegisterRequest request){
                User user =new User();
                user.setUsername(request.getUsername());
                user.setPassword(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                );
//                 user.setPassword(request.getPassword());
                user.setRole("USER");
                return userRepository.save(user);
            }
            private final PasswordEncoder passwordEncoder;
//        public User login (String username){
//            return userRepository.findByUsername(username).orElseThrow(()->
//                    new RuntimeException("User Not Found"));
//        }

    public void encryptExistingUsers() {
    }
//    @Autowired
//    private PasswordEncoder PasswordEncoder;
        public String login(LoginRequest request) {
        System.out.println(
                "Username ="
                + request.getUsername());

            User user = userRepository.findByUsername(
                            request.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if(!passwordEncoder.matches(
                    request.getPassword(),
                    user.getPassword())){
                throw new RuntimeException("Invalid Password");
            }
            return JwtUtil.generateToken(
                    user.getUsername());
        }
}
