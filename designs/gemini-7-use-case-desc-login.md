## Use Case Description

<b>Use Case Name</b>: Log in &emsp;&emsp;<b>ID</b>: 1&emsp;&emsp; <b>Importance Level</b>: High<br />
<b>Primary Actor</b>: Users &emsp;&emsp; <b>Use Case Type</b>: Detail, Essential<br />
<b>Stakeholders and Interests</b>:<br />
&emsp;Users— Wants to log into the system<br />
<b>Brief Description</b>:This use case describes how a user log in to the system.<br />
<b>Trigger</b>: User press login from their computer.<br />
<b>Type</b>: External<br />
&emsp;<b>Relationships</b>:<br />
&emsp;<b>Association</b>: Users<br />
&emsp;<b>Include</b>:<br />
&emsp;<b>Extend</b>:<br />
&emsp;<b>Generalization</b>:<br />
<b>Normal Flow of Events</b>:<br />
&emsp;1.User input username<br />
&emsp;2.User input password<br />
&emsp;3.User press login<br />
&emsp;System checks for existing account database.<br />
&emsp;&emsp;If username and password is valid:<br />
&emsp;&emsp;&emsp;System accepts user into the menu.<br />
&emsp;&emsp;If username and password is invalid:<br />
&emsp;&emsp;&emsp;System notify the user an error message.<br />
&emsp;&emsp;&emsp;System sends user back to the input system.<br />
<b>Alternate/Exceptional Flows</b>:<br />
&emsp;1: The users need existing account in order for the system to grant access.<br />
