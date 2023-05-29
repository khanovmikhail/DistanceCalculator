package com.khanovmikhail.distancecalculator.controller;

import com.khanovmikhail.distancecalculator.controller.request.DistanceRequest;
import com.khanovmikhail.distancecalculator.controller.response.CityResponse;
import com.khanovmikhail.distancecalculator.controller.response.DistanceResponse;
import com.khanovmikhail.distancecalculator.service.CityService;
import com.khanovmikhail.distancecalculator.service.DistanceService;
import com.khanovmikhail.distancecalculator.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MyRESTController {
    @Autowired
    private CityService cityService;

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("/city")
    public List<CityResponse> getCity(){
        return cityService.getAllCitiesList();
    }

    @PostMapping("/distance")
    public List<DistanceResponse> calculateDistance(@RequestBody DistanceRequest distanceRequest) {
        return distanceService.calculateDistance(distanceRequest);
    }

    @PostMapping(path = "/upload", produces = {"application/json", "application/xml"}, consumes = "multipart/form-data")
    public ResponseEntity<?> uploadXml(@RequestParam(name = "file") MultipartFile multipartFile){
        uploadFileService.uploadXml(multipartFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
