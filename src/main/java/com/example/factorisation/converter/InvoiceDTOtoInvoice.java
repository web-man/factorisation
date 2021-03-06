package com.example.factorisation.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.service.BusinessPartnerService;
import com.example.factorisation.service.BusinessYearService;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.InvoiceItemsService;

import dto.InvoiceDTO;

@Component
public class InvoiceDTOtoInvoice implements Converter<InvoiceDTO, Invoice>{

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private BusinessYearService businessYearService;
	
	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@Autowired
	private InvoiceItemsService invoiceItemsService;
	
	@Override
	public Invoice convert(InvoiceDTO arg0) {
		
		Invoice i = new Invoice();
		
		i.setId(arg0.getId());
		i.setInvoiceNumber(arg0.getInvoiceNumber());
		i.setInvoiceDate(arg0.getInvoiceDate());
		i.setValueDate(arg0.getValueDate());
		i.setInvoiceStatus(arg0.getInvoiceStatus());
		
		Company company = companyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			i.setCompany(company);
		}
		
		BusinessYear businessYear = businessYearService.findOne(arg0.getBusinessYearId());
		if(businessYear!=null) {
			i.setBusinessYear(businessYear);
		}
		
		BusinessPartner businessPartner = businessPartnerService.findOne(arg0.getBusinessPartnerId());
		if(businessPartner!=null) {
			i.setBusinessPartner(businessPartner);
		}
		
		List<InvoiceItems> invoiceItems = new ArrayList<InvoiceItems>();
		List<Long> invoiceItemsIds = arg0.getInvoiceItemIds();
		for (Long id : invoiceItemsIds) {
			InvoiceItems in = invoiceItemsService.findOne(id);
			invoiceItems.add(in);
		}
//		
		if(invoiceItems!=null) {
			i.setInvoice_Items(invoiceItems);
		}
		
		return i;
	}
}
