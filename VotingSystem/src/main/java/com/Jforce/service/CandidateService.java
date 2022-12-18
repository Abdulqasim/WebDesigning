package com.Jforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Jforce.model.Candidate;
import com.Jforce.repository.CandidateRepository;

@Service
public class CandidateService {
	@Autowired
	private CandidateRepository cr;
	
	//add
	public Candidate add(Candidate candidate) {
		return this.cr.save(candidate);
	}
	//get by all
	public Iterable<Candidate> getAll() {
		return this.cr.findAll();
	}
	//get by id
	public Candidate getById(Integer id) {
		return this.cr.findById(id).orElseThrow(
				()->{
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,"candidate with id not exists");
				}
				); 
	}
	//update by id
	public Candidate updateById(Candidate candidate, Integer id) {
		this.getById(id);
		candidate.setId(id);
		return this.cr.save(candidate);
		
	}
	//delete by id
	public void deleteById(Integer id) {
		this.cr.deleteById(id);
	}
	

}
