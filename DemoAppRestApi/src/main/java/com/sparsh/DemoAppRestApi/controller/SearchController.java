package com.sparsh.DemoAppRestApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparsh.DemoAppRestApi.exception.ResourceNotFoundException;
import com.sparsh.DemoAppRestApi.model.SearchModel;
import com.sparsh.DemoAppRestApi.repository.SearchRepository;



@RestController
@RequestMapping("/api")
public class SearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchRepository searchRepository;
	
	// ******* Get All Company Details *******
	
	@GetMapping("/getAllCompanies")
	public List<SearchModel> getAllCompanies(){
		return searchRepository.findAll();
	}
	
	// ******* Get Company details by companyId *******
	
	@GetMapping("/getCompany/{id}")
	public SearchModel getCompanyById(@PathVariable(value = "id") Long companyId) {
		
		return searchRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("SearchModel", "id", companyId));
	}
	
	// ******* Get Company details by companyName *******

	/*@GetMapping("/search")
	public List<SearchModel> searchCompany(@PathVariable(value = "company_name") String company_name) {
		
		return searchRepository.searchWithJPQLQuery(company_name);
	}*/
	
	
	
	//@RequestMapping(value = "/search", method = RequestMethod.GET)
	
	
	@GetMapping("/search/{searchTerm}")
    public List<SearchModel> searchCompany(@PathVariable("searchTerm") String searchTerm) {
        LOGGER.info("Finding todo entries by search term: {}", searchTerm);

        List<SearchModel> searchResults = searchRepository.searchWithJPQLQuery(searchTerm);
        LOGGER.info("Found {} todo entries", searchResults.size());

        return searchResults;
    }

	// ******* Update Company Details *******
	
	@PutMapping("/updateCompany/{id}")
	public SearchModel updateCompany(@PathVariable(value = "id") Long companyId, @Valid @RequestBody SearchModel companyDetails) {

		SearchModel comp = searchRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("SearchModel", "id", companyId));

		comp.setCompanyName(companyDetails.getCompanyName());

		SearchModel updatedCompany = searchRepository.save(comp);
		
		return updatedCompany;
	}
	//
		
}
