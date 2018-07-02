package com.oneorg.devices.services;

import com.oneorg.devices.events.source.SimpleSourceBean;
import com.oneorg.devices.model.Device;
import com.oneorg.devices.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DevicesService {
    @Autowired
    private DeviceRepository devRepository;

    @Autowired
    SimpleSourceBean simpleSourceBean;

    public Device getDev(String devId) {
        return devRepository.findById(devId);
    }

    public void saveDev(Device dev){
        dev.setId( UUID.randomUUID().toString());

        devRepository.save(dev);
        simpleSourceBean.publishDevChange("SAVE", dev.getId());
    }

    public void updateDev(Device dev){
        devRepository.save(dev);
        simpleSourceBean.publishDevChange("UPDATE", dev.getId());

    }

    public void deleteDev(Device dev){
        devRepository.delete( dev.getId());
        simpleSourceBean.publishDevChange("DELETE", dev.getId());
    }
}
