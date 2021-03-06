package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseTaskCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{testBaseId}/testBaseTasks")
public class TestBaseTaskController {

    private final TestBaseTaskService service;

    @Autowired
    public TestBaseTaskController(TestBaseTaskService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestBaseTaskDTO>> getTestBaseTasks(@PathVariable Integer testBaseId) {
        List<TestBaseTaskDTO> tasksToReturn = service.getTestBaseTasks(testBaseId);
        return new ResponseEntity<>(tasksToReturn, HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestBaseTaskDTO> createTestBaseTask(@PathVariable Integer testBaseId, @RequestBody TestBaseTaskCreateDTO task) {
        try {
            TestBaseTaskDTO savedTask = service.addTestBaseTask(testBaseId, task);
            return new ResponseEntity<>(savedTask, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{testBaseTaskId}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteTestBaseTask(@PathVariable Integer testBaseTaskId) {
        try {
            service.deleteTestBaseTask(testBaseTaskId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
