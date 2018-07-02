package com.oneorg.rawdata.clients;

import com.oneorg.rawdata.model.Data;
import com.oneorg.rawdata.repository.DataRepository;
import com.oneorg.rawdata.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Component;

@Component
public class ArtikCloudRestTemplateClient {
    @Autowired
    private DataRepository dataRepository;

    private static final Logger logger = LoggerFactory.getLogger(ArtikCloudRestTemplateClient.class);

    private Data checkCache(String deviceId) {
        try {
            return dataRepository.findByDeviceId(deviceId);
        }
        catch (Exception ex){
            logger.error("Error encountered while trying to retrieve data {} check DB Cache.  Exception {}", deviceId, ex);
            return null;
        }
    }

    private void cacheDataObject(Data data) {
        try {
            dataRepository.saveData(data);
        }catch (Exception ex){
            logger.error("Unable to cache data {} in DB. Exception {}", data.getId(), ex);
        }
    }

    public String getData(String deviceId){
        logger.debug("In Data Service.getData: {}", UserContext.getCorrelationId());

        // Data data = checkCache(deviceId);

        // if (data!=null){
        //     logger.debug("I have successfully retrieved data {} from the DB cache: {}", deviceId, data);
        //     return data;
        // }

        logger.debug("Unable to locate organization from the DB cache: {}.", deviceId);

        String server = "https://api.artik.cloud/v1.1/messages/last?count=10&sdids=3dcc6661784f4bd2b21dc0a8ccf47084";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer 84f792c411614df49f45806d0017bd04");
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server, HttpMethod.GET, requestEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        

        /*Save the record from cache*/
        String json = responseEntity.getBody();
        logger.debug("Response from cloud: {}", json);
        // if (data!=null) {
        //     cacheDataObject(data);
        // }

        return json;
    }

}
