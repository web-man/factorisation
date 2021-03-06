package com.example.factorisation.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.GroupOfGoods;
import dto.GoodsOrServicesDTO;

public class GoodsOrServicesToGoodsOrServicesDTO implements Converter<GoodsOrServices, GoodsOrServicesDTO>{

	@Override
	public GoodsOrServicesDTO convert(GoodsOrServices arg0) {
		
		GoodsOrServicesDTO g = new GoodsOrServicesDTO();
		
		g.setId(arg0.getId());
		g.setName(arg0.getName());
		g.setUnit(arg0.getUnit());
		
		if(arg0.getGroupOfGoods() != null) {
			g.setGroupOfGoodsId(((GroupOfGoods) arg0.getGroupOfGoods()).getId());
		}
		
		if(arg0.getPricelist_Items() != null) {
			g.setPricelistItemsId(((GoodsOrServices) arg0.getPricelist_Items()).getId());
		}
		
		if(arg0.getInvoice_Items() != null) {
			g.setInvoiceItemsId(((GoodsOrServices) arg0.getInvoice_Items()).getId());
		}
		
		return g;
	}
	
	public List<GoodsOrServicesDTO> convert(List<GoodsOrServices> goodsorservices){
		
		List<GoodsOrServicesDTO> retVal = new ArrayList<GoodsOrServicesDTO>();
		
		for (GoodsOrServices goodsOrServices : goodsorservices) {
			retVal.add(convert(goodsOrServices));
		}
		
		return retVal;	
	}
}
