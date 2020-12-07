package com.kzmpekos.postcodesdistancecalculatorservice.DomainLayer.services;

import com.kzmpekos.postcodesdistancecalculatorservice.DomainLayer.repositories.PostcodesWithCoordinatesRepository;
import com.kzmpekos.postcodesdistancecalculatorservice.DomainLayer.entities.PostcodesWithCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorService {
    @Autowired
    private PostcodesWithCoordinatesRepository repository;

    public float calculate(String postcodeUser, String postcodeFarmer) {
        //Getting the coordinates of the given postcodes
        PostcodesWithCoordinates userPostcodeWithCoordinates=repository.findByPostcode(postcodeUser);
        PostcodesWithCoordinates farmerPostcodeWithCoordinates=repository.findByPostcode(postcodeFarmer);
        double latitudeUser=userPostcodeWithCoordinates.getLatitude();
        double latitudeFarmer=farmerPostcodeWithCoordinates.getLatitude();
        double longitudeUser=userPostcodeWithCoordinates.getLongitude();
        double longitudeFarmer=userPostcodeWithCoordinates.getLongitude();
        //REFERENCE: https://iopscience.iop.org/article/10.1088/1742-6596/1500/1/012104/pdf
        final int R=6371;
        //Converting to radians
        double Δlat=Math.toRadians(latitudeFarmer-latitudeUser);
        double Δlong=Math.toRadians(longitudeFarmer-longitudeUser);
        //calculating the distance
        double distance=2*R*Math.asin(Math.sqrt(Math.pow(Math.sin(Δlat/2),2)+Math.cos(latitudeFarmer)*Math.cos(latitudeUser)*Math.pow(Math.sin(Δlong/2),2)));
        return (float)Math.round(distance*100)/100;
    }
}
