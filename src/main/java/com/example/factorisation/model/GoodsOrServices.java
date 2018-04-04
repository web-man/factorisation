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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GoodsOrServices {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(50)")
	private String name;
	
	@Column(name="Unit", columnDefinition="VARCHAR(15)")
	private String unit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private GroupOfGoods groupOfGoods;
	
	@OneToMany(mappedBy="goodsOrServices", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PricelistItems> pricelist_Items = new ArrayList<PricelistItems>();
	
	@OneToMany(mappedBy="goodsOrServices", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<InvoiceItems> invoice_Items = new ArrayList<InvoiceItems>();
	
	public GoodsOrServices() {
	}

	public GoodsOrServices(String name, String unit) {
		this.name = name;
		this.unit = unit;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public GroupOfGoods getGroupOfGoods() {
		return groupOfGoods;
	}

	public void setGroupOfGoods(GroupOfGoods groupOfGoods) {
		this.groupOfGoods = groupOfGoods;
	}

	public List<PricelistItems> getPricelist_Items() {
		return pricelist_Items;
	}

	public void setPricelist_Items(List<PricelistItems> pricelist_Items) {
		this.pricelist_Items = pricelist_Items;
	}

	public List<InvoiceItems> getInvoice_Items() {
		return invoice_Items;
	}

	public void setInvoice_Items(List<InvoiceItems> invoice_Items) {
		this.invoice_Items = invoice_Items;
	}


}
