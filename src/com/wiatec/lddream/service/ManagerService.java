package com.wiatec.lddream.service;

import com.wiatec.lddream.orm.dao.ManagerDao;
import com.wiatec.lddream.orm.pojo.ManagerInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * manager service
 */
@Service
public class ManagerService {

    @Resource
    private ManagerDao managerDao;

    @Transactional(readOnly = true)
    public boolean validate(ManagerInfo managerInfo){
        return managerDao.countOne(managerInfo) == 1;
    }
}
