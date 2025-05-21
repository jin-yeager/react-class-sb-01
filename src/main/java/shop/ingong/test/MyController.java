package shop.ingong.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.ingong.dto.StoreVo;

import java.util.ArrayList;

@Controller
public class MyController {

    @GetMapping("/hello")  // This maps HTTP GET requests to the /hello path
    public String hello() {
        return "Hello, Spring Boot World!";
    }
    @GetMapping("/welcome")
    public String welcome( Model model) {
        String a = "홍길동";
        String[] b = {"전우치","이순신"};
        ArrayList<StoreVo> c = new ArrayList<>();
        c.add(new StoreVo("1","1"));
        c.add(new StoreVo("2","2"));

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);

        return "welcome";
    }

    @GetMapping("/param")
    public String param(@RequestParam String menu, StoreVo st, HttpServletRequest req, Model model) {
        System.out.println("menu : "+menu);
        System.out.println("st : "+st);
        System.out.println("req : "+req.getParameter("menu"));

        model.addAttribute("menu", menu);
        return "param";
    }
    @PostMapping("/post")
    public String post(@RequestParam String menu, StoreVo st, HttpServletRequest req, Model model) {
        System.out.println("menu : "+menu);
        System.out.println("st : "+st);
        System.out.println("req : "+req.getParameter("menu"));

        model.addAttribute("menu", menu);

        return "post";
    }
}
