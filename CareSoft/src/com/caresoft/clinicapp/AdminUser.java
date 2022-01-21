package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    		super(id);
    		this.role = role;
    		this.securityIncidents = new ArrayList<String>();
    }
    
    
    // TO DO: Implement HIPAACompliantUser!

	@Override
    public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 6) {
			setPin(pin);
			return true;
		} else {
			return false;			
		}
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == getId()) {
			return true;
		} else {
			authIncident();
			return false;			
		}
    }
    
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    		return getSecurityIncidents();
    }
    
    // Class Methods
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }


	// TO DO: Setters & Getters
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}


	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    

}
