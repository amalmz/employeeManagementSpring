package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.Leave;
import com.bezkoder.springjwt.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LeaveService")

public class LeaveService {
    private LeaveRepository LeaveRepository;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository) {
        this.LeaveRepository = leaveRepository;
    }


    public String addLeave(Leave leavedet) {

        LeaveRepository.save(leavedet);
        return "Leave has been added, user name = " + leavedet.getEmployeeId();


    }

    public List<Leave> findAllUser() {
        List<Leave> leaveList = (List<Leave>) LeaveRepository.findAll();
        if (leaveList != null) {
            return leaveList;
        }
        return null;
    }

    public String updateLeave(String employeeId,String fromdate,String leavetype) {

        Leave l = LeaveRepository.findByEmployeeIdAndFromdate(employeeId, fromdate);
        if(l!=null) {
            l.setLeavetype(leavetype);
            LeaveRepository.save(l);

        }
        return "Leave has been added, user name = " + l.getEmployeeId();


    }

    public Leave[] findByEmployeeId(String employeeId) {
        Leave[] leaveList = LeaveRepository.findByEmployeeId(employeeId);
        if (leaveList != null) {
            return leaveList;
        }
        return null;
    }


    public Leave[] findByDepartmentId(String deptid) {
        //System.out.println("HELLO"+deptid);
        Leave[] leaveList = LeaveRepository.findByDeptId(deptid);
        if (leaveList != null) {
            return leaveList;
        }
        return null;
    }
    public String deleteByEmpid(String employeeid) {
        LeaveRepository.deleteByEmployeeId(employeeid);
        return "Leave data has been deleted successfully.";

    }
}
