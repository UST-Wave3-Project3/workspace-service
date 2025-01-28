package com.project.workspace_service.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.workspace_service.repository.entity.Workspace;
import com.project.workspace_service.service.WorkspaceService;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {
	
	@Autowired
	WorkspaceService workspaceService;
	
	@GetMapping
	public ResponseEntity<List<Workspace>> getAllWorkspaces(){
		return new ResponseEntity<List<Workspace>>(workspaceService.getAllWorkspaces(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{workspaceId}")
    public ResponseEntity<Optional<Workspace>> getWorkspaceById(@PathVariable int workspaceId) {
        return new ResponseEntity<Optional<Workspace>>(workspaceService.getWorkspaceById(workspaceId),HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<Workspace> addWorkspace(@RequestBody Workspace newWorkspace){
		return new ResponseEntity<Workspace>(workspaceService.addWorkspace(newWorkspace),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Workspace> updateWorkspace(@RequestBody Workspace editWorkspace){
		return new ResponseEntity<Workspace>(workspaceService.addWorkspace(editWorkspace),HttpStatus.OK);
	}
	
	@DeleteMapping("/{workspaceId}")
	public ResponseEntity<Void> deleteWorkspace(@PathVariable int workspaceId){
		workspaceService.deleteWorkspace(workspaceId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/seat")
	public ResponseEntity<List<Workspace>> getWorkspaceByAvailability(@RequestParam("workspaceAvailable") boolean availability){
		return new ResponseEntity<List<Workspace>>(workspaceService.getWorkspaceByAvailability(availability),HttpStatus.OK);
	}
	
	@GetMapping("/monitor")
	public ResponseEntity<List<Workspace>> getWorkspaceByMonitor(@RequestParam("hasMonitor") boolean monitor){
		return new ResponseEntity<List<Workspace>>(workspaceService.getWorkspaceByMonitor(monitor),HttpStatus.OK);
	}
	
	@GetMapping("/whiteboard")
	public ResponseEntity<List<Workspace>> getWorkspaceByWhiteboard(@RequestParam("hasWhiteboard") boolean whiteboard){
		return new ResponseEntity<List<Workspace>>(workspaceService.getWorkspaceByWhiteboard(whiteboard),HttpStatus.OK);
	}
	
	@GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getWorkspaceCounts() {
        Map<String, Long> stats = workspaceService.getWorkspaceStatistics();
        return ResponseEntity.ok(stats);
    }
}
