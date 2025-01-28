package com.project.workspace_service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="workspace_service")
public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="workspace_id")
	private int workspaceId;
	
	@Column(name="seat_number",unique = true)
	private String seatNumber;
	
	@Column(name="workspace_building")
	private String workspaceBuilding;
	
	@Column(name="workspace_floor")
	private String workspaceFloor;
	
	@Column(name="has_whiteboard")
	private boolean hasWhiteboard;
	
	@Column(name="has_monitor")
	private boolean hasMonitor;
	
	@Column(name="workspace_available")
	private boolean workspaceAvailable;
}
