package com.example.db.swagger.dao;

import com.example.db.swagger.types.EmpConfigIdentifier;
import com.example.db.swagger.types.EmpDetails;

public interface DmDbService {

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id);

}
