package com.gafarov.bastion.repository;

import com.gafarov.bastion.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}