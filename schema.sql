show databases;
use workspace;
create table workspace_details( 
	workspace_id int auto_increment primary key,
    seat_number varchar(10),
    workspace_building varchar(100),
    workspace_floor varchar(100),
    has_whiteboard boolean,
    has_monitor boolean,
    workspace_available boolean
    );
    