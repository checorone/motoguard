package com.oneorg.devices.controllers;


import com.oneorg.devices.events.source.SimpleSourceBean;
import com.oneorg.devices.model.Device;
import com.oneorg.devices.services.DevicesService;
import com.oneorg.devices.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value="v1/devices")
public class DevicesServiceController {
    @Autowired
    private DevicesService devService;
    private static final Logger logger = LoggerFactory.getLogger(DevicesServiceController.class);

    @RequestMapping(value="/{deviceId}",method = RequestMethod.GET)
    public Organization getDevice( @PathVariable("deviceId") String deviceId) {
        logger.debug("Looking up data for dev {}", deviceId);

        Device dev = devService.getDev(deviceId);
        return dev;
    }

    @RequestMapping(value="/{deviceId}",method = RequestMethod.PUT)
    public void updateDevice( @PathVariable("deviceId") String devId, @RequestBody Device dev) {
        devService.updateDev( dev );

    }

    @RequestMapping(value="/{deviceId}",method = RequestMethod.POST)
    public void saveDevice(@RequestBody Device dev) {
       devService.saveDev( dev );
    }

    @RequestMapping(value="/{deviceId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice( @PathVariable("deviceId") String devId,  @RequestBody Device dev) {
        devService.deleteDev( dev );
    }
}
