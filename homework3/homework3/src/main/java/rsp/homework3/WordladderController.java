package rsp.homework3;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
=======
// import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
>>>>>>> c7c56f8eecf1c23c28b1278df2403d1e9155a3c4
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordladderController {
    @Autowired
    DiscoveryClient discoveryClient;

<<<<<<< HEAD
    @GetMapping("/test")
    public String test() {
        return "hello world";
=======
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
>>>>>>> c7c56f8eecf1c23c28b1278df2403d1e9155a3c4
    }
}
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.awt.*;
//
//@RestController
//@EnableAutoConfiguration
//public class WordladderController {
//
//    @Autowired
//    RestTemplate rt;
//
//    @RequestMapping("/ladder")
//    public String ladder(@RequestParam(value = "u") String username,
//                            @RequestParam(value = "p") String password,
//                            @RequestParam(value = "b") String begin,
//                            @RequestParam(value = "e") String end) {
//
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(begin);
//        System.out.println(end);
//        //验证用户权限过程
//        try{
//            rt = new RestTemplate();
//            String url = "http://localhost:8060/login?u="+username+"&p="+password;
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
////        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
//
//            System.out.println("start");
//            ResponseEntity<String> response = rt.getForEntity(url, String.class);
//
//            System.out.println(response);
//            String responsedata = response.getBody();
//
//            System.out.println(responsedata);
//
//            if(responsedata.equals("true")){
//                Wordladder wl = new Wordladder();
//                return wl.ss(begin,end);
//            }else{
//                return "Please Enter valid parameters!";
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            return "Please Enter valid parameters!";
//        }
//        //验证通过，给出结果
//    }
//}