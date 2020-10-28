## Use Case Description

<b>Use Case Name</b>: Create a science plan &emsp;&emsp;<b>ID</b>: 1&emsp;&emsp;<b>Importance Level</b>: High <br />

<b>Primary Actor</b>:&nbsp; Astronomer &emsp;&emsp;&emsp;<b>Use Case Type</b>: Detail, Essential<br />

<b>Stakeholders and Interests</b>:<br />
&emsp;Astronomer — Wants to create a science plan<br />

<b>Brief Description</b>: This use case describes how the astronomer creates a science plan in OCS system<br />

<b>Trigger</b>: Astronomer wants to create a science plan<br />
<b>Type</b>: External<br />

<b>Relationships</b>:<br/>
&emsp;	<b>Association</b>: Astronomer<br />
&emsp;	<b>Include</b>:<br />
&emsp;	<b>Extend</b>:<br />
&emsp;	<b>Generalization</b>:<br />

<b>Normal Flow of Events</b>:<br />
&emsp;1. The astronomer fills in the name of the creator<br />
&emsp;2. The astronomer fills in the name of the sunmitter<br />
&emsp;3. The astronomer fills in the name funding organization<br />
&emsp;4. The astronomer fills in the underlying objective<br />
&emsp;5. The astronomer chooses star system from drop down box<br />
&emsp;6. The astronomer chooses date and time<br />
&emsp;7. The astronomer chooses telescope (for location)<br />
&emsp;8. The astronomer fills in the data processing requirements<br />
&emsp;9. The astronomer chooses duration of observation<br />
&emsp;10. The astronomer searches for an associated science plan in database<br />
&emsp;&emsp;&emsp;	If a science plan is found,<br />
&emsp;&emsp;&emsp;&emsp;	   the S-1: retrieve science plan sub-flow is performed<br />
&emsp;&emsp;&emsp;	If a science plan is not found,<br />
&emsp;&emsp;&emsp;&emsp;	   the S-2: file a science plan sub-flow is performed<br />

<b>SubFlows</b>:<br />
&emsp;S-1: Retrieve science plan<br />
&emsp;&emsp;	1. The astronomer retrieve a completed science plan<br />
&emsp;S-2: File Science Plan<br />
&emsp;&emsp;	1. The astronomer files a science plan<br />
&emsp;&emsp;	2. The astronomer saves a science plan into database<br /><br />
<b>Alternate/Exceptional Flows</b>:<br />
&emsp;1: The astronomers are required to log in to the OCS system first, then they may do their works.<br />
