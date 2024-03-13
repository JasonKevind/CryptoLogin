package com.example.demo;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "*")
@RestController
public class Apis {
    @Autowired
    private Repo repos;
    @Autowired
    private Password pass;
    @PostMapping("/Login")
    public HashMap<String,String> Login(@RequestBody clients p1){
        HashMap<String,String> hm=new HashMap<>(1);
        if(repos.existsByEmailid(p1.getEmailid()) && pass.pass().matches(p1.getPassword(),repos.findByEmailid(p1.getEmailid()).get(0).getPassword())){
            hm.put("1","Authenticated");
        }
        else{
            hm.put("0","Not Authenticated");
        }
        return hm;  
    }
    @PostMapping("/SignUp")
    public HashMap<String,String> verify(@RequestBody clients p1) {
        HashMap<String,String> hm=new HashMap<>(1);
        System.out.println("jdfvjskjs");
        try{
        if(!repos.existsByEmailid(p1.getEmailid())){
        p1.setPassword(pass.pass().encode(p1.getPassword()));
        repos.save(p1);
        hm.put("1","Registered");}
        else
        {
            hm.put("0","Already Registered");
        }
        return hm;
        }
        catch(Exception e){
            hm.put("-1","Please try later...");
            return hm;
        }
    }
}