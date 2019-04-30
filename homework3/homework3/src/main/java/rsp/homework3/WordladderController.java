package rsp.homework3;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@Controller
@EnableAutoConfiguration
public class WordladderController {

    @RequestMapping("/ladder")
    public String ladder(@RequestParam(value = "u") String username,
                            @RequestParam(value = "p") String password,
                            @RequestParam(value = "b") String begin,
                            @RequestParam(value = "e") String end) {


        System.out.println(username);
        System.out.println(password);
        //验证用户权限过程
//        String userName = "admin";
//        String passWord = "123";
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost/8600/login?u="+username+"&p="+password;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<String> entity = new HttpEntity<String>(body, headers);

        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        String responsedata = response.getBody();

        System.out.println(responsedata);
        //验证通过，给出结果

        Wordladder wl = new Wordladder();
        return wl.ss(begin,end);
    }
}