package net.bbenarbia.web.dto;

public class AvailabilityStatus {

	private boolean valid;
	private String[] suggestions;
	
	public AvailabilityStatus() {
		super();
	}
	public AvailabilityStatus(boolean valid) {
		super();
		this.valid = valid;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String[] getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String[] suggestions) {
		this.suggestions = suggestions;
	}
	
	
	
}
