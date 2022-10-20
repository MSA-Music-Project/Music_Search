package com.example.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dtos.MusicSearchReturn;
import com.example.models.MusicReview;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class MusicSearchService {
	
	
	private final RestTemplate restTemplate;
	
	public MusicSearchService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;	
	}
	
	@Retry(name="searchBackend", fallbackMethod="searchBackup")
	public List<MusicSearchReturn> search(String s){
		
		URI uri = URI.create("http://localhost:9000/review/all"); //make a controller method @GetMapping in MusicReiviewService
		
		MusicReview[] allReviews = restTemplate.getForObject(uri, MusicReview[].class);
		
		List<MusicReview> reviewList = Arrays.asList(allReviews);
		
		List<MusicSearchReturn> matchingReview = new LinkedList<>();
		
		for(MusicReview m : reviewList) {
			if(m.getSongName().contains(s)) {
				matchingReview.add(new MusicSearchReturn(m.getCritiqueId(),m.getSongName(),m.getArtist(),m.getSongLength(),m.getGenre(),m.getSongCritique()));
			}
		}
		return matchingReview;
		
		
		
		
	}
	
	public List<MusicSearchReturn> searchBackup(String s, Exception e){
		
		List<MusicSearchReturn> emptySearch = new ArrayList <> ();
		
		emptySearch.add(new MusicSearchReturn(0, "NONE", "NONE", 0.0, "NONE","NONE"));
		
		return emptySearch;
	}

}
