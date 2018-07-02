package com.oneorg.devices.events.source;

import com.oneorg.devices.event.models.DeviceChangeModel;
import com.oneorg.devices.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishDevChange(String action,String devId){
        logger.debug("Sending Kafka message {} for Device Id: {}", action, devId);
        DeviceChangeModel change =  new deviceChangeModel(
                DeviceChangeModel.class.getTypeName(),
                action,
                orgId,
                UserContext.getCorrelationId());

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
