## Use Case Description

<b>Use Case Name</b>: Validate a science plan &emsp;&emsp;<b>ID</b>: 5 &emsp;&emsp;<b>Importance Level</b>: High<br />

<b>Primary Actor</b>: Science Observer &emsp;&emsp;&emsp;<b>Use Case Type</b>: Detail, Essential<br />

<b>Stakeholders and Interests</b>:<br />
&emsp;Science Observer — wants to validate the science plan whether it is worth performing or not<br />
<b>Brief Description</b>: <br />
&emsp;This use case describes how a science observer validate the science plans and determine whether the science plan is accepted or rejected, also, how to handle them.<br />
<b>Trigger</b>: Science observer receives a science plan<br />
<b>Type</b>: External<br />
<b>Relationships</b>:<br />
&emsp; <b>Association</b>: Science Observer<br />
&emsp; <b>Include</b>:<br />
&emsp; <b>Extend</b>:<br />
&emsp; <b>Generalization</b>:<br />

<b>Normal Flow of Events</b>:<br />
&emsp;1. The science observer selects an unchecked science plan<br />
&emsp;2. The science observer checks schedule, observatory location, number of observatories, and occupation schedule<br />
&emsp;&emsp;&emsp;If the schedule is feasible,<br />
&emsp;&emsp;&emsp;&emsp;the S1: analyze request sub-flow is performed <br />
&emsp;&emsp;&emsp;If the schedule is not feasible,<br />
&emsp;&emsp;&emsp;&emsp;the science oberver rejects the science plan and update the databse<br />
<b>SubFlows</b>:<br />
&emsp;S-1: Analyze Request<br />
&emsp;&emsp;1. The science observer checks for the existing record of science plan in database<br />
&emsp;&emsp;2. The science observer analyze the science plan<br />
&emsp;&emsp;&emsp;If science plan is worth performing both financially and academically,<br />
&emsp;&emsp;&emsp;&emsp;1a. The science observer accepts the science plan and update science plan status in database<br />
&emsp;&emsp;&emsp;If science plan is not worth performing both financially and academically,<br />
&emsp;&emsp;&emsp;&emsp;1b. The science observer rejects the science plan and update science plan status in database<br />


<b>Alternate/Exceptional Flows</b>:<br />
&emsp;1. The science observers are required to log in to the OCS system first, then they may perform their works.
