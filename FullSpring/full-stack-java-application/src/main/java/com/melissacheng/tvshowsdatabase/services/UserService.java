package com.melissacheng.tvshowsdatabase.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.melissacheng.tvshowsdatabase.models.LoginUser;
import com.melissacheng.tvshowsdatabase.models.User;
import com.melissacheng.tvshowsdatabase.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> all() {
		return repository.findAll();
	}
	
	public User save(User item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public User retrieve(Long itemId) {
		Optional<User> optionalUser = repository.findById(itemId);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	// Register and login methods
    public User register(User newUser, BindingResult result) {
    	
    	// Reject values or register if no errors:
    	Optional<User> potentialUser = repository.findByEmail(newUser.getEmail());
    	
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email already registered. Please log in with email");
    	} else if (!newUser.getPassword().equals((newUser.getConfirm()))) {
    		result.rejectValue("password", "Matches", "Passwords do not match");
    	} else if (result.hasErrors()) {
    		return null;
    	} else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return repository.save(newUser);
    	}
    	
        return null;
    }
    
    
    public User login(LoginUser newLogin, BindingResult result) {
        
    	Optional<User> potentialUser = repository.findByEmail(newLogin.getEmail());
    	
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email not found. Please register with email.");
    	} else if (!BCrypt.checkpw(newLogin.getPassword(), potentialUser.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password");
    	} else if (result.hasErrors()) {
    		return null;
    	} else {
    		return potentialUser.get();
    	}

        return null;
    }
    
//    Check if User is logged in
    public User retrieveCurrentUser(HttpSession session) {
    		if (session.getAttribute("user_id") == null) return null;
    		return this.retrieve((Long) session.getAttribute("user_id"));
    }
	
}
