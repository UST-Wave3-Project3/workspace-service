package com.project.workspace_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.workspace_service.repository.WorkspaceRepository;
import com.project.workspace_service.repository.entity.Workspace;

@Service
public class WorkspaceService {
	
	@Autowired
	WorkspaceRepository workspaceRepository;
	
	public List<Workspace> getAllWorkspaces(){
		return workspaceRepository.findAll();
	}
	
	public Optional<Workspace> getWorkspaceById(int workspaceId) {
		return workspaceRepository.findById(workspaceId);
	}
	
	public Workspace addWorkspace(Workspace newWorkspace) {
		return workspaceRepository.saveAndFlush(newWorkspace);
	}
	
	public Workspace updateWorkspace(Workspace editWorkspace) {
		return workspaceRepository.save(editWorkspace);
	}
	
	public void deleteWorkspace(int workspaceId) {
		workspaceRepository.deleteById(workspaceId);
	}
	
	public List<Workspace> getWorkspaceByAvailability(boolean availability) {
        return workspaceRepository.findByWorkspaceAvailable(availability);
    }
	
	public List<Workspace> getWorkspaceByMonitor(boolean monitor) {
        return workspaceRepository.findByHasMonitor(monitor);
    }
	
	public List<Workspace> getWorkspaceByWhiteboard(boolean whiteboard) {
        return workspaceRepository.findByHasWhiteboard(whiteboard);
    }
	
	public Map<String, Long> getWorkspaceStatistics() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalSlots", workspaceRepository.countTotalSlots());
        stats.put("availableCount", workspaceRepository.countAvailableSlots());
        stats.put("notAvailableCount", workspaceRepository.countUnavailableSlots());
        stats.put("WhiteboardCount", workspaceRepository.countWhiteboard());
        stats.put("MonitorCount", workspaceRepository.countMonitor());
        return stats;
    }
	

}
