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
import cloud.artik.client.ApiClient;
import cloud.artik.client.ApiException;
import cloud.artik.client.Configuration;
import cloud.artik.client.auth.*;
import cloud.artik.model.SubscriptionEnvelope;
import cloud.artik.model.SubscriptionInfo;
import cloud.artik.api.SubscriptionsApi;

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

    // private void cacheDataObject(Data data) {
    //     try {
    //         dataRepository.saveData(data);
    //     }catch (Exception ex){
    //         logger.error("Unable to cache data {} in DB. Exception {}", data.getDeviceId(), ex);
    //     }
    // }

    public void subscribe(String deviceId){
        logger.debug("In subscribe method: {}", UserContext.getCorrelationId());

        // Data data = checkCache(deviceId);

        // if (data!=null){
        //     logger.debug("I have successfully retrieved data {} from the DB cache: {}", deviceId, data);
        //     return data;
        // }

        //logger.debug("Unable to locate organization from the DB cache: {}.", deviceId);

      ApiClient defaultClient = Configuration.getDefaultApiClient();

      // Configure OAuth2 access token for authorization: artikcloud_oauth
      OAuth artikcloud_oauth = (OAuth) defaultClient.getAuthentication("artikcloud_oauth");
      artikcloud_oauth.setAccessToken("c8f17e3149174eb18959dce27b6381ff");

      SubscriptionsApi apiInstance = new SubscriptionsApi();
      SubscriptionInfo subscriptionInfo = new SubscriptionInfo();
      subscriptionInfo.setMessageType("message");
      subscriptionInfo.setSdid("3dcc6661784f4bd2b21dc0a8ccf47084");
      subscriptionInfo.setSubscriptionType("httpCallback");
      try {
          SubscriptionEnvelope result = apiInstance.createSubscription(subscriptionInfo);
          logger.info(result.toString());
      } catch (ApiException e) {
          logger.warn("Exception when calling SubscriptionsApi#createSubscription");
          e.printStackTrace();
      }
        

        /*Save the record from cache*/
        // if (data!=null) {
        //     cacheDataObject(data);
        // }
    }

}
