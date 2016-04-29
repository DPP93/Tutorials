/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.spring.tutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Daniel
 */
@Entity
public class Bookmark {
    
    @JsonIgnore
    @ManyToOne
    private Account account;
    
    @Id
    @GeneratedValue
    private Long id;
    
    public String uri;
    public String description;
    
    Bookmark(){
        
    }
    
    public Bookmark(Account account, String uri, String description){
        this.account = account;
        this.uri = uri;
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
