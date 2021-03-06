package dto;

import java.util.Date;

public class PricelistDTO {
	
	private Long Id;
	
	private Date date_of_validity;
	
	private Long companyId;
	
	private Long pricelistItemsId;
	
	public PricelistDTO() {
		
	}
	
	public PricelistDTO(Long id, Date date_of_validity, Long companyId, Long pricelistItemsId) {
		super();
		Id = id;
		this.date_of_validity = date_of_validity;
		this.companyId = companyId;
		this.pricelistItemsId = pricelistItemsId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate_of_validity() {
		return date_of_validity;
	}

	public void setDate_of_validity(Date date_of_validity) {
		this.date_of_validity = date_of_validity;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getPricelistItemsId() {
		return pricelistItemsId;
	}

	public void setPricelistItemsId(Long pricelistItemsId) {
		this.pricelistItemsId = pricelistItemsId;
	}
	
	

}
