package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;
import com.app.pojos.Venues;

@Repository
public interface IVenues extends JpaRepository<Venues, Integer>{
	
	@Query(value = "SELECT * FROM Venues v WHERE v.specific_area = :area", 
			  nativeQuery = true)

	List<Venues> findbyloc(@Param("area") String area);
	
	@Query(value = "SELECT * FROM Venues v WHERE v.vname = :vname", 
			  nativeQuery = true)
	Venues findbyname(@Param("vname") String vname);

}
