package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	/*
	 * @GetMapping public String getRequest(){
	 * 
	 * return "This is get method"; }
	 */
	
	@GetMapping(path= "/{userId}")
    public String getRequestuser(@PathVariable String userId) {
        return "This is get method with path " + userId; 
    }  
	
	@GetMapping()
    public String getRequestquer(@RequestParam(value = "page") int pageno, @RequestParam(value = "limit") int limitno){
        return "This is get method with path " + pageno + "limit is:" + limitno; 
    }  
	
	
	@PostMapping
	public String createRequest(){
		
		return "This is post method"; 
	}
	
	@PutMapping
	public String putRequest(){
		
		return "This is put method"; 
	}
	
	@DeleteMapping
	public String deleteRequest(){
		
		return "This is delete method"; 
	}

	

}
