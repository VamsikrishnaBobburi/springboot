package com.CollegeList.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CollegeList.Entity.College;
import com.CollegeList.Repositroy.CollegeRepositroy;




@RestController
@RequestMapping("/college")
public class CollegeControler {
	
	@Autowired
	private CollegeRepositroy collegerepositroy ; 

	@RequestMapping(path ="/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	@RequestMapping(path ="/id/{id}")
	public ResponseEntity<java.util.List<College>> getById(@PathVariable Integer id) {
		
		List<College> listCollege = collegerepositroy.findByTotalStudent(id);
		return new ResponseEntity<>(listCollege, HttpStatus.OK);
	}
	
	@PostMapping(path ="/add")
	public ResponseEntity<College> addCollege(@RequestBody College newCollege) {
		
		College college = collegerepositroy.save(newCollege);
		return new ResponseEntity<>(college, HttpStatus.OK);
	}
	
	
	
}
