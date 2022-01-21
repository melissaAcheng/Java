package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
     
	// Member Variable
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
    		super(id);
    		this.patientNotes = new ArrayList<String>();
    }
   

	// TO DO: Implement HIPAACompliantUser!
    @Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 4) {
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
			return false;			
		}
	}
    
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


    // TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}


	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


	
	

}
