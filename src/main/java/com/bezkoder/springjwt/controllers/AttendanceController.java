package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Attendance;
import com.bezkoder.springjwt.security.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/attendancedetail")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceservice;

    @PostMapping(path = "/addatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody Attendance attendancedetail) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.addUser(attendancedetail));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }



//	 @PostMapping(path = "/addatten")
//	 @ResponseBody
//	 public String addUser(@RequestBody AttendanceDetail attendancedetail) {
//
//	        	attendanceservice.addUser(attendancedetail);
//
//	 }



    @GetMapping(path = "/findAllatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> findAllUser() {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findAllUser());
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }


    @GetMapping(path = "/findbyempidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> findByempid(@RequestParam String employeeid) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findByempid(employeeid));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }


    @GetMapping(path = "/findbyDandmanda")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> countByDepartmentIdAndMonthAndAvailable(@RequestParam String employeeid,@RequestParam String departmentid,@RequestParam String month,@RequestParam Boolean available) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.countByDepartmentIdAndMonthAndAvailable(departmentid,month,available));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }
    }

    @GetMapping(path = "/findbyDandm")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> countByDepartmentIdAndMonth(@RequestParam String departmentid,@RequestParam String month) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.countByDepartmentIdAndMonth(departmentid,month));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }
    }


    @GetMapping(path = "/findbyEandDandm")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> countByEmployeeIdAndDepartmentIdAndMonth(@RequestParam String employeeid,@RequestParam String departmentid,@RequestParam String date) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.countByEmployeeIdAndDepartmentIdAndMonth(employeeid,departmentid,date));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }
    }

    @GetMapping(path = "/findbyEandD")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> countByEmployeeIdAndDepartmentId(@RequestParam String employeeid,@RequestParam String departmentid) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.countByEmployeeIdAndDepartmentId(employeeid,departmentid));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }
    }

    @GetMapping(path = "/findbyEandDandA")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> countByEmployeeIdAndDepartmentIdAndAvailable(@RequestParam String employeeid,@RequestParam String departmentid,@RequestParam Boolean available) {
        HttpHeaders headers = new HttpHeaders();
        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.countByEmployeeIdAndDepartmentIdAndAvailable(employeeid,departmentid,available));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }


    }

    @GetMapping(path = "/findbydepidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> findBydeptid(@RequestParam String departmentid) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body( attendanceservice.findBydeptid(departmentid));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }


    }

    @GetMapping(path = "/findbydate")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> findBydate(@RequestParam String month) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.findBydate(month));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }



    @GetMapping(path = "/sortview")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> sortdeptview(@RequestParam String departmentId,@RequestParam String month,@RequestParam String shift) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.sortdeptview(departmentId,month,shift));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }



    @GetMapping(path = "/findbybothidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Attendance findByName(@RequestParam String employeeid,@RequestParam String departmentid) {
        return attendanceservice.findByName(employeeid, departmentid);
    }


    @GetMapping(path = "/updateatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestParam String employeeid,@RequestParam Boolean available,@RequestParam String date) {
        HttpHeaders headers = new HttpHeaders();

        try {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.updateUser(employeeid,available,date));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }

    @GetMapping(path = "/deletebyempidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public String deleteByEmpid(@RequestParam String employeeid) {
        return attendanceservice.deleteByEmpid(employeeid);
    }


    @GetMapping(path = "/deletebydepidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public ResponseEntity<?> deleteBydeptid(@RequestParam String departmentid) {
        HttpHeaders headers = new HttpHeaders();

        try {
            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.deleteBydeptid(departmentid));
        }catch (Exception e) {
            headers.add("Message", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
        }

    }


    @GetMapping(path = "/deletebybothidatten")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public String deleteByUserNameAndPassword(@RequestParam String employeeid, @RequestParam String departmentid) {
        return attendanceservice.deleteByUserNameAndPassword(employeeid, departmentid);
    }
}
