package com.example.SD2.edu.gemini.app.ocs;


//import com.example.SD2.edu.gemini.app.ocs.example.MySciencePlan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
//        MySciencePlan mySP = new MySciencePlan();
//        mySP.setDescription("test");
        return "welcome to Gemini world!";

    }
}
