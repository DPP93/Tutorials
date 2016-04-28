/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.tutorial.spring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Daniel
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();
    
    @JsonIgnore
    public String password;
    public String username;
    
    public Account(String name, String password){
        this.username = name;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }
    
    Account(){
        
    }
    
}
