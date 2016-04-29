/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.spring.tutorial.rest;

import bookmarks.Account;
import bookmarks.AccountRepository;
import bookmarks.Bookmark;
import bookmarks.BookmarkRepository;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author dpp
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class BookmarkRestControllerTest {
    
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    private MockMvc mockMvc;
    private String userName = "badman";
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    private Account account;
    private List<Bookmark> bookmarkList = new ArrayList<>();
    
    @Autowired
    private BookmarkRepository bookmarkRepository;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters){
        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
        hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();
        
        Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
    }
    
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        //Clean up all of this
        this.bookmarkRepository.deleteAllInBatch();
        this.accountRepository.deleteAllInBatch();
        
        this.account = accountRepository.save(new Account(userName, "password"));
        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/"+userName, "Description")));
        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/"+userName, "Description")));
    }
    
    @Test
    public void userNotFound(){
    
    }
}
