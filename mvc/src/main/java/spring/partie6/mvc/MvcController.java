package spring.partie6.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MvcController {

    @RequestMapping("/")
    public String index (){
        return "index";
    }

    @GetMapping("/file1")
    public String file1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
         return "file1";
    }

}