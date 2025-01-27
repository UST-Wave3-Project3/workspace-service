package com.project.workspace_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.workspace_service.repository.entity.Workspace;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Integer>{
	
	List<Workspace> findByWorkspaceAvailable(boolean availability);
	
	List<Workspace> findByHasMonitor(boolean monitor);
	
	List<Workspace> findByHasWhiteboard(boolean whiteboard);
	
	@Query("SELECT COUNT(w) FROM Workspace w")
    long countTotalSlots();

    @Query("SELECT COUNT(w) FROM Workspace w WHERE w.workspaceAvailable = true")
    long countAvailableSlots();

    @Query("SELECT COUNT(w) FROM Workspace w WHERE w.workspaceAvailable = false")
    long countUnavailableSlots();
    
    @Query("SELECT COUNT(w) FROM Workspace w WHERE w.hasWhiteboard = true")
    long countWhiteboard();
    
    @Query("SELECT COUNT(w) FROM Workspace w WHERE w.hasMonitor = true")
    long countMonitor();

}
