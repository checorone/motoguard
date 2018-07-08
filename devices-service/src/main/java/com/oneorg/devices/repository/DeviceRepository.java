package com.oneorg.devices.repository;

import com.oneorg.devices.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device,String>  {
    public Device findById(String deviceId);
}
