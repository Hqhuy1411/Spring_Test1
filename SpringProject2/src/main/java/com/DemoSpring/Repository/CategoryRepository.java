package com.DemoSpring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DemoSpring.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	@Query("SELECT a.name FROM CategoryEntity a ")
	List<String> findAllName();
	@Query("SELECT a FROM CategoryEntity a WHERE a.name=:name")
	CategoryEntity findOneByName(@Param("name") String name);
}
