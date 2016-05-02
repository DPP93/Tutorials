/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.spring.tutorial.validatingforminput;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dpp
 */
public class PersonForm {
    
    @Size(min=2, max=30)
    private String name;
    
    @NotNull
    @Min(18)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(" + "name=" + name + ", age=" + age + "}";
    }
    
    
    
}
