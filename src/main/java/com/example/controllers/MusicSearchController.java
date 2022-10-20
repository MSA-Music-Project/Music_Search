package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.MusicSearchReturn;
import com.example.service.MusicSearchService;

@RestController
//@RequestMapping("/search")
public class MusicSearchController {
	
	@Autowired
	MusicSearchService mSearch;
	
	@GetMapping("/{val}")
	public ResponseEntity<List<MusicSearchReturn>> search(@PathVariable String val){
		
		return ResponseEntity.ok(this.mSearch.search(val));
		
	}

}
