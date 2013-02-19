package net.bbenarbia.domain.dto;

public class ContactDto {

	private String contactName;
	private String contactCompany;
	private String contactAdress;
	private String contactPostalCode;
	private String contactTown;
	private String contactEmail;
	private String contactPhone1;
	private String contactPhone2;

	public ContactDto() {
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(final String contactName) {
		this.contactName = contactName;
	}

	public String getContactCompany() {
		return contactCompany;
	}

	public void setContactCompany(final String contactCompany) {
		this.contactCompany = contactCompany;
	}

	public String getContactAdress() {
		return contactAdress;
	}

	public void setContactAdress(final String contactAdress) {
		this.contactAdress = contactAdress;
	}

	public String getContactPostalCode() {
		return contactPostalCode;
	}

	public void setContactPostalCode(final String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}

	public String getContactTown() {
		return contactTown;
	}

	public void setContactTown(final String contactTown) {
		this.contactTown = contactTown;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(final String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(final String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(final String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}
}
