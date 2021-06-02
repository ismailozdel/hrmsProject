package com.example.demo.dataAccess.abstracts;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.entities.concretes.Job;
import com.example.demo.entities.dtos.JobDto;


public interface JobDao extends JpaRepository<Job, Integer>{
	
	List<Job> getByIsActivated(Boolean bool);
	List<Job> getByPosition(String position);
	List<Job> findByIsActivatedOrderByReleaseDateDesc(Boolean bool);
	List<Job> getByEmployerId_Id(int id);
//	@Query("From Job where isActivated=true ")
//	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
//	List<Product> getByNameAndCategory(String productName, String categoryId);
	//@Query("Select new com.example.demo.entities.dtos.JobDto(j.companyName, j.position, j.avaiblePositionNumber, j.releaseDate, j.applicationDeadline) From Job j ")
	//List<JobDto> getJobList();
	
	//@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
}
