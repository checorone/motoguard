package com.oneorg.rawdata.controllers;

import com.oneorg.rawdata.model.Data;
import com.oneorg.rawdata.services.DataService;
import com.oneorg.rawdata.config.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="v1/data")
public class DataServiceController {
    @Autowired
    private DataService dataService;

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(DataServiceController.class);


    @RequestMapping(value="/{deviceId}",method = RequestMethod.GET)
    public String getData( @PathVariable("deviceId") String deviceId) {

        return dataService.getMessage(deviceId);
    }

    // @RequestMapping(value="/notify",method = RequestMethod.POST)
    // public License getLicenses() {
    //     logger.debug("Found tmx-correlation-id in license-service-controller: {} ", request.getHeader("tmx-correlation-id"));
    //     return licenseService.getLicense(organizationId, licenseId);
    // }

    @RequestMapping(value="/{deviceId}",method = RequestMethod.PUT)
    public void updateData( @PathVariable("deviceId") String deviceId, @RequestBody Data data) {
        dataService.updateData(data);
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveData(@RequestBody Data data) {
        dataService.saveData(data);
    }

    @RequestMapping(value="/{dataId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteData( @PathVariable("dataId") String dataId, @RequestBody Data data) {
         dataService.deleteData(data);
    }
}
