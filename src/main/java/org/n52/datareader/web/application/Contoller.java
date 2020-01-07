package org.n52.datareader.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Contoller {
    @GetMapping
    String index(){
        return "index";
    }
}
