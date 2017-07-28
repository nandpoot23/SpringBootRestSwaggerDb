package com.example.db.swagger.impl;

import com.example.db.swagger.types.EmpConfigIdentifier;
import com.example.db.swagger.types.EmpDetails;

public abstract interface DmServiceInterface {

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id);

}
