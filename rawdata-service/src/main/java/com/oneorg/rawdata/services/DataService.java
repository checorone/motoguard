package com.oneorg.rawdata.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.oneorg.rawdata.clients.ArtikCloudRestTemplateClient;
import com.oneorg.rawdata.model.Data;
import com.oneorg.rawdata.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    ArtikCloudRestTemplateClient artikCloudRestClient;


    @HystrixCommand
    public Data getData(String deviceId) {
        Data data = dataRepository.findByDeviceId(deviceId);
        return data;
    }

    @HystrixCommand
    public String getMessage(String messageId) {
        // return artikCloudRestClient.getMessage(messageId);
        return "";
    }

    // public void saveData(Data data){
    //     dataRepository.save(data);
    // }

    // public void updateData(Data data){
    //     dataRepository.save(data);
    // }

    public void deleteData(Data data){
        dataRepository.delete( data.getDeviceId());
    }

}
