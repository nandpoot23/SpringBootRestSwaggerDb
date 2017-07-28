package com.example.db.swagger.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.db.swagger.dao.DmDbService;
import com.example.db.swagger.types.EmpConfigIdentifier;
import com.example.db.swagger.types.EmpDetails;

@Component("DmServiceImpl")
public class DmServiceImpl implements DmServiceInterface {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DmServiceImpl.class);

    @Autowired
    DmDbService dmDbService;

    @Override
    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::queryEmpConfigs  id : " + id.getId());
        }
        return dmDbService.queryEmpConfigs(id);
    }

}
