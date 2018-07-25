package com.sparsh.DemoAppRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sparsh.DemoAppRestApi.model.SearchModel;


@Repository
public interface SearchRepository extends JpaRepository <SearchModel, Long> {
	
	//@Query("select u from company_details u where u.company_name like ?1%")
	//@Query("select * from company_details where company_name like ?%")
	
	//select * from company_details where company_name like 'ros%';
	//List<SearchModel> findByCompanyNameStartingWith(String company_name);
	
	@Query("SELECT count(p) FROM company_details p WHERE p.company_name LIKE %:searchTerm%")
    public List<SearchModel> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
	
}
