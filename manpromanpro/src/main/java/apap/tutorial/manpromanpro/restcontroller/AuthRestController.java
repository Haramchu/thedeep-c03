package apap.tutorial.manpromanpro.restcontroller;

import apap.tutorial.manpromanpro.security.jwt.JwtUtils;
import apap.tutorial.manpromanpro.model.UserModel;
import apap.tutorial.manpromanpro.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private UserDb userDb;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        UserModel user = userDb.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtUtils.generateJwtToken(username);

            Map<String, Object> response = new HashMap<>();
            response.put("status", 200);
            response.put("message", "Login berhasil!");
            response.put("timestamp", LocalDateTime.now());
            Map<String, String> data = new HashMap<>();
            data.put("token", token);
            response.put("data", data);

            return ResponseEntity.ok(response);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("status", 401);
        response.put("message", "Username atau Password salah!");
        response.put("timestamp", LocalDateTime.now());
        response.put("data", null);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
