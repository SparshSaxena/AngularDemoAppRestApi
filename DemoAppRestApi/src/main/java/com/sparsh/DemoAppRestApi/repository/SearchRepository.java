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
	
	//@Query("SELECT count(p) FROM SearchModel p WHERE p.country_code LIKE %:searchTerm%")
	//@Query("SELECT p FROM SearchModel p WHERE LOWER(p.company_name) = LOWER(:searchTerm)")
	//@Query("select count(p) from SearchModel where company_name like 'searchTerm%'")
	//@Query("select u. from SearchModel u where u.company_name like %?1")
	
	
	
	//@Query("SELECT u FROM SearchModel u WHERE u.company_name LIKE CONCAT('%',:searchTerm,'%')")
	@Query("SELECT u FROM SearchModel u WHERE u.company_name LIKE :searchTerm%")
    List<SearchModel> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
	
}
