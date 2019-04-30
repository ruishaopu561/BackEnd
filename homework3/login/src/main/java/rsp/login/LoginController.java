package rsp.login;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "u") String username, @RequestParam(value = "p") String password)
    {
        if (username.equals("admin") && password.equals("123"))
        {
            return "true";
        } else {
            return "false";
        }
    }
}
