package com.CollegeList.Repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CollegeList.Entity.College;


public interface CollegeRepositroy extends JpaRepository<College, Long> {

	List<College> findByTotalStudent(Integer id);

}