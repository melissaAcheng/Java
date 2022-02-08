package com.melissacheng.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.melissacheng.authentication.models.LoginUser;
import com.melissacheng.authentication.models.User;
import com.melissacheng.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
    	Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
    	
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email already registered. Please log in with email");
    	} else if (!newUser.getPassword().equals((newUser.getConfirm()))) {
    		result.rejectValue("password", "Matches", "Passwords do not match");
    	} else if (result.hasErrors()) {
    		return null;
    	} else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return userRepository.save(newUser);
    	}
            
            // Reject if email is taken (present in database)
            // Reject if password doesn't match confirmation
            
            // Return null if result has errors
        
            // Hash and set password, save user to database
    	
        return null;
    }
    public User login(LoginUser newLogin, BindingResult result) {
// TO-DO - Reject values:
        
    	Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
    	
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email not found. Please register with email.");
    	} else if (!BCrypt.checkpw(newLogin.getPassword(), potentialUser.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password");
    	} else if (result.hasErrors()) {
    		return null;
    	} else {
    		return potentialUser.get();
    	}
    	// Find user in the DB by email
        // Reject if NOT present
        
        // Reject if BCrypt password match fails
    
        // Return null if result has errors
        // Otherwise, return the user object
        return null;
    }
    
    // Gets one user
    public User findUser(Long id) {
    	Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
    }
    
}
