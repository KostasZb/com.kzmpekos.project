package com.kzmpekos.commissionservice;

import com.kzmpekos.commissionservice.entities.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commission,Integer> {
    public List<Commission> findAllByUserId(int id);

}
