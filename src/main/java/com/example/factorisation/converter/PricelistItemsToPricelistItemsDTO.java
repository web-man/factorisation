package com.example.factorisation.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.model.PricelistItems;
import dto.PricelistItemsDTO;

public class PricelistItemsToPricelistItemsDTO implements Converter<PricelistItems, PricelistItemsDTO>{

	@Override
	public PricelistItemsDTO convert(PricelistItems arg0) {
		
		PricelistItemsDTO p = new PricelistItemsDTO();
		
		p.setId(arg0.getId());
		p.setPrice(arg0.getPrice());
		
		
		if(arg0.getPricelist() != null) {
			p.setPricelistId(((Pricelist) arg0.getPricelist()).getId());
		}
		
		if(arg0.getGoodsOrServices() != null) {
			p.setGoodsOrServicesId(((GoodsOrServices) arg0.getGoodsOrServices()).getId());
		}
		
		
		return p;
	
}
	
	public List<PricelistItemsDTO> convert(List<PricelistItems> pricelistitems){
		
		List<PricelistItemsDTO> retVal = new ArrayList<PricelistItemsDTO>();
		
		for (PricelistItems pricelistItems : pricelistitems) {
			retVal.add(convert(pricelistItems));
		}
		
		return retVal;	
	}
	
}
