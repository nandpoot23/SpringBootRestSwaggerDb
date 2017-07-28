package com.example.db.swagger.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.db.swagger.types.EmpConfigIdentifier;
import com.example.db.swagger.types.EmpDetails;

@Repository("DmDbServiceImpl")
public class DmDbServiceImpl implements DmDbService {

    private static final Logger LOG = LoggerFactory.getLogger(DmDbServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        List<EmpDetails> configList = new ArrayList<EmpDetails>();
        List<Integer> args = new ArrayList<Integer>();
        args.add(id.getId());

        String query = "select * from employee where id = ?";

        try {
            configList = jdbcTemplate.query(query, args.toArray(), new EmpConfigResultSetExtractor());
            LOG.debug(" Query for queryEmpConfigs : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting emp configurations  ", e);
        }

        if (!configList.isEmpty()) {

            return configList.get(0);
        } else {
            return null;
        }
    }

}
