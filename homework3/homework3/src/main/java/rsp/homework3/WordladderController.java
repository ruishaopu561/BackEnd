package rsp.homework3;

// import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordladderController {

    @RequestMapping("/ladder")
    public String ladder(@RequestParam(value = "u") String username, @RequestParam(value = "p") String password,
            @RequestParam(value = "b") String begin, @RequestParam(value = "e") String end) {

        System.out.println(username);
        System.out.println(password);
        // 验证用户权限过程
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8900/login?u={1}&p={2}";

        String response = rt.getForObject(url, String.class, username, password);

        System.out.println(response);
        // 验证通过，给出结果

        if (response.equals("true")) {
            Wordladder wl = new Wordladder();
            return wl.ss(begin, end);
        } else {
            return "User not exist.";
        }
    }
}