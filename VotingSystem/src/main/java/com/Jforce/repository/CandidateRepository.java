package com.Jforce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Jforce.model.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer>{

}
