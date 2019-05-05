package rsp.login;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class LoginController {

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "u") String username, @RequestParam(value = "p") String password) {
        if (username.equals("admin") && password.equals("123")) {
            return "true";
        } else {
            return "false";
        }
    }
}
