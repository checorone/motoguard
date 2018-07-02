package com.oneorg.rawdata.repository;

import com.oneorg.rawdata.model.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CrudRepository<Data,String>  {
    public License findByDeviceId(String deviceId);
}
