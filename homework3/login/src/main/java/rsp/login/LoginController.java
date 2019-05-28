<<<<<<< HEAD
//package rsp.login;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//
//@Controller
//@EnableAutoConfiguration
//public class LoginController {
//    String result="false";
//
//    @RequestMapping("login")
//    public void getLogin(@RequestParam(value = "u") String username,
//                           @RequestParam(value = "p") String password)
//    {
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(username.equals("admin") && password.equals("123"));
//        if (username.equals("admin") && password.equals("123"))
//        {
//            this.result =  "true";
//        } else {
//            this.result = "false";
//        }
//    }
//}
=======
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
>>>>>>> c7c56f8eecf1c23c28b1278df2403d1e9155a3c4
