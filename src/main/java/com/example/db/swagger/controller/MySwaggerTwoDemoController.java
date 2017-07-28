package com.example.db.swagger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.swagger.impl.DmServiceInterface;
import com.example.db.swagger.types.EmpConfigIdentifier;
import com.example.db.swagger.types.EmpDetails;

@RestController
@RequestMapping(value = "/dmSwagger/demo/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MySwaggerTwoDemoController {

    private static final Logger LOG = LoggerFactory.getLogger(MySwaggerTwoDemoController.class);

    @Autowired
    DmServiceInterface dmServiceInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test() {
        return "Swagger DB App is running";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/manu", produces = MediaType.TEXT_PLAIN_VALUE)
    public String manu() {
        System.out.println("******Swagger DB App*******");
        return "Swagger two DB App is running";
    }

    @Lazy(false)
    @RequestMapping(method = RequestMethod.POST, value = "/empConfig", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmpDetails> getEmpConfiguration(@RequestBody EmpConfigIdentifier id) {
        LOG.info("starting .........");
        if (LOG.isDebugEnabled())
            LOG.debug("Received Request for getEmpConfiguration {} ", id);

        EmpDetails response = dmServiceInterface.queryEmpConfigs(id);

        if (LOG.isDebugEnabled())
            LOG.debug("Returning Response for getEmpConfiguration");

        return new ResponseEntity<EmpDetails>(response, HttpStatus.OK);
    }

}
