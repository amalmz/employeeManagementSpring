package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LeaveRepository extends CrudRepository<Leave, Long> {

    Leave[] findByEmployeeId(String employeeId);

    Leave findByEmployeeIdAndFromdate(String employeeId, String fromdate);

    Leave[] findByDeptId(String deptId);


    @Transactional
    void deleteByEmployeeId(String employeeId);

}
