/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.tutorials.spring.springbootquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Daniel
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
    
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "I'm not going to say: Hello World!";
    }
    
    public static void main(String[] args){
        SpringApplication.run(SampleController.class, args);
    }
}
