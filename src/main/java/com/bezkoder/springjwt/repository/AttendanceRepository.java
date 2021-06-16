package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Attendance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    Attendance[] findByEmployeeId(String employeeid);


    Attendance[] findByDepartmentId(String departmentid);

    Attendance findBydate(String month);

    Attendance findByEmployeeIdAndDepartmentId(String employeeid,String departmentid);


    Long countByEmployeeIdAndDepartmentId(String employeeid,String departmentid);

    Long countByEmployeeIdAndDepartmentIdAndAvailable(String employeeid,String departmentid,Boolean available);

    Long countByEmployeeIdAndDepartmentIdAndMonth(String employeeid,String departmentid,String month);

    @Query(value = "SELECT count(*) as total FROM attendance where department_id = ?1 and month = ?2 group by id")
    Long countByDepartmentIdAndMonth(String departmentid,String month);

    Long countByDepartmentIdAndMonthAndAvailable(String departmentid,String month,Boolean available);

    @Transactional
    void deleteByEmployeeIdAndDepartmentId(String employeeid,String departmentid);

    @Transactional
    void deleteByDepartmentId(String departmentid);

    @Transactional
    void deleteByEmployeeId(String employeeid);

    Attendance findByEmployeeIdAndDate(String employeeid, String date);

    @Query(value = "SELECT employeeId,count(available) as total FROM attendance where available=1 and department_id = ?1 and month = ?2 and shift = ?3 group by id order by count(available) desc")
    Object[] findByAttencountOrderByAttencountAsc(String departmentid,String month,String shift);
}
