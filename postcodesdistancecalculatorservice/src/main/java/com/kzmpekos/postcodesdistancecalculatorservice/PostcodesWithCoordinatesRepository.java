package com.kzmpekos.postcodesdistancecalculatorservice;

import com.kzmpekos.postcodesdistancecalculatorservice.entities.PostcodesWithCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostcodesWithCoordinatesRepository extends JpaRepository<PostcodesWithCoordinates,Integer> {
    public PostcodesWithCoordinates findByPostcode(String postcode);
}
