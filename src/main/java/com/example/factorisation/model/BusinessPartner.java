package com.example.factorisation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class BusinessPartner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="Address", columnDefinition="VARCHAR(40)")
	private String address;
	
	@Column(name="Type", columnDefinition="CHAR(2)")
	private String type;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "businessPartner_company", joinColumns = @JoinColumn(name = "businesPartner_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
	List<Company> companies = new ArrayList<Company>();
	//@ManyToOne(fetch=FetchType.EAGER)
	//private Company company;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
	@JsonIgnore
	@OneToMany(mappedBy="businessPartner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<Invoice>();
	
	public BusinessPartner() {
	}

	public BusinessPartner(String name, String address, String type, City city, Company company, List<Company> companies) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.city = city;
		this.companies = companies;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}


}
