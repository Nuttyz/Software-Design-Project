# Instructions

### How to run the system
1. Change PATH variable in the application.properties (in "SD2nut\src\main\resources") according to the path to the "Gemini7DB.db" file on your machine <b>(jdbc:h2:file:<YOUR PATH>/SD2nut/Gemini7DB.db)</b> <br />
2. Click Run in the IntelliJ <br />
3. Open login.html that contains in the "SD2nut\src\main\resources\templates" <br />
4. Perform actions according to the use cases below <br />


<b>NOTE</b> <br />
• Link for creating an astronomer user in case that you create a new database (http://localhost:8080/add?id=1&name=Sirichoke%20Yooyen&username=Amzky101&password=123456&role=Science%20Observer) <br />
• Link for creating a science observer user in case that you create a new database (http://localhost:8080/add?id=2&name=Nuttapon%20Rungruang&username=Nty000&password=123456&role=Astronomer) <br />
• Link for accessing the h2 database (http://localhost:8080/h2-console)<br />
&nbsp;&nbsp;&nbsp;&nbsp;• <b>Username</b>: sa<br />
&nbsp;&nbsp;&nbsp;&nbsp;• <b>Password</b>: <br />
• H2:DATABASE - User, Science Plan, IMAGE_STAR (star system image), and Astronomical Data (info about the test of that science plan, selected image of star system on the plan) <br />
• Science Observer user <br />
  &nbsp;&nbsp;&nbsp;&nbsp;• <b>Username</b>: Amzky101 <br />
  &nbsp;&nbsp;&nbsp;&nbsp;• <b>Password</b>: 123456 <br />
• Astronomer user <br />
  &nbsp;&nbsp;&nbsp;&nbsp;• <b>Username</b>: Nty000 <br />
  &nbsp;&nbsp;&nbsp;&nbsp;• <b>Password</b>: 123456 <br />

### Use Case 1: Create a Science Plan
1. Log in as an astronomer user (username:Nty000,password:123456) <br />
2. Click Create a Science Plan button <br />
3. Fill in the information of the science plan <br />
4. Click submit button to finish and return to home page <br />
5. The status of science plan will change to ‘running’ and will store in the database <br />
### Use Case 2: Test a Science Plan
1. Log in as an astronomer user (username:Nty000,password:123456) <br />
2. Click Test a Science Plan button <br />
3. Select the science plan number (there will be a list of science plan display above the form (only the plans with status "operated" will appear)), angle of telescope, and check for validity <br />
4. Click the test science plan button, then system will display the picture of star system (randomly) <br />
5. User can select the status to be “REJECTED” or “TESTED” (means it’s ok) for the science plan <br />
6. (optional) You can add some additional comment <br />
7. Click submit button to finish and return to home page <br />
8. The status of science plan will change to ‘tested’ and will store in the database <br />

### Use Case 3: Operate the Interactive Observing Program
1. Log in as an astronomer user (username:Nty000,password:123456) <br />
2. Click Operate the Interactive Observing Program button <br />
3. User input the id of science plan that they want to operate and the location of telescope (there will be a list of science plan display above the form (only the plans with status "operated" will appear)) <br />
4. User click the operate to see that the telescope can operate or not <br />
5. If telescope can operate, it will show the picture that operated from the telescope after that it will update status automatically and then goto home page. Else, it will pop up message that show that this science plan cannot operate. Thus, it will reject this science plan automatically. <br />
6. The status of science plan will change to ‘operated’ and will store in the database <br />

### Use Case 4: Submit a Science Plan
1. Log in as an astronomer user (username:Nty000,password:123456) <br />
2. Select the science plan number (there will be a list of science plans (only the plans with status "operated" will appear) display above the form) <br />
3. User can select the status to be “REJECTED” or “SUBMITED” (means it’s ok) for the science plan <br />
4. Click submit button and return to home page <br />
5. The status of science plan will change to ‘submitted’ and will store in the database <br />

### Use Case 5: Validate a Science Plan
1. Log in as an science oberver user  (username:Amzky101,password:123456) <br />
2. Click Validate Science Plan <br />
3. Only science plans that has status ‘submitted’ will appear on the list <br />
4. Fill in the information of the science plan  <br />
5. Click Finish button <br />
6. The status of science plan will change to ‘complete’ and will store in the database <br />

### Pattern
We selected facade pattern because we use only one controller which is createSciencePlanController. Thus, it can make us easy to manage and fix some bug, so it can hide the complexity in our code. Moreover, it can reduce time to find only one file when we fix or implement the function.
