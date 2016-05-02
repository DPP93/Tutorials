/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.spring.tutorial.validatingforminput;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *
 * @author dpp
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm(PersonForm personForm){
        return "form";
    }
    
    @RequestMapping(value="/kutacz", method=RequestMethod.GET)
    public String showSomething(){
        return "results";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }
}
