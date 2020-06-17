package com.hcl.intranet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.intranet.beans.Employee;
import com.hcl.intranet.service.IntranetService;

import io.swagger.annotations.Api;

@Api(value = "Intranet operations")
@RestController
@RequestMapping("/v2")
public class IntranetController {
	
	private static final Logger LOG = LoggerFactory.getLogger(IntranetController.class); 

	@Autowired
	IntranetService intranetService;
	
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployeeList() {
    	LOG.info("Getting all employee list");
        return ResponseEntity.ok(intranetService.getEmployees());
    }
    
    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
    	LOG.info("Getting all employee list");
        return ResponseEntity.ok("test user API");
    }
    
    @GetMapping("/employee/{sapId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String sapId) {
        return ResponseEntity.ok(intranetService.getEmployee(sapId));
    }
    
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    	LOG.info("Create employee -----");
        return ResponseEntity.ok(intranetService.addEmployee(employee));
    }
    
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(intranetService.updateEmployee(employee));
    }
    
    @DeleteMapping("/employee/{sapId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable String sapId) {
        return ResponseEntity.ok(intranetService.removeEmployee(sapId));
    }
    
}
