package com.kzmpekos.postcodesdistancecalculatorservice.services;

import com.kzmpekos.postcodesdistancecalculatorservice.PostcodesWithCoordinatesRepository;
import com.kzmpekos.postcodesdistancecalculatorservice.entities.PostcodesWithCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorService {
    @Autowired
    private PostcodesWithCoordinatesRepository repository;

    public float calculate(String postcodeUser, String postcodeFarmer) {
        PostcodesWithCoordinates userPostcodeWithCoordinates=repository.findByPostcode(postcodeUser);
        PostcodesWithCoordinates farmerPostcodeWithCoordinates=repository.findByPostcode(postcodeFarmer);
        double latitudeUser=userPostcodeWithCoordinates.getLatitude();
        double latitudeFarmer=farmerPostcodeWithCoordinates.getLatitude();
        double longitudeUser=userPostcodeWithCoordinates.getLongitude();
        double longitudeFarmer=userPostcodeWithCoordinates.getLongitude();
        //REFERENCE: https://iopscience.iop.org/article/10.1088/1742-6596/1500/1/012104/pdf
        final int R=6371;
        double Δlat=Math.toRadians(latitudeFarmer-latitudeUser);
        double Δlong=Math.toRadians(longitudeFarmer-longitudeUser);
        double d=2*R*Math.asin(Math.sqrt(Math.pow(Math.sin(Δlat/2),2)+Math.cos(latitudeFarmer)*Math.cos(latitudeUser)*Math.pow(Math.sin(Δlong/2),2)));

        return (float)d;
    }
}
