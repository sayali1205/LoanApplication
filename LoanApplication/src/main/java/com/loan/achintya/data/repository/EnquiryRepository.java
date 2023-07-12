package com.loan.achintya.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.achintya.data.model.Enquiry;
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

}
