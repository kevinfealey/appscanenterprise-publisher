#AppScan Enterprise Publisher Plugin for Jenkins

##Project Description
Configuring IBM Security AppScan Source scans in Jenkins can be time-consuming and error-prone when custom batch or shell scripts are used. This Jenkins plugin greatly simplifies the running of AppScan Source from Jenkins by providing centralized global settings and straight-forward input fields for scan configuration.

##This plugin requires (Prerequisites):

1. AppScan Source installed on the Jenkins Server
2. AppScan Source application/project (PAF, PPF, etc.) artifacts on the Jenkins server
3. Source code and dependencies referenced in the AppScan Source artifacts on the Jenkins server
4. AppScan Source login token
5. AppScan Enterprise (w/ Enterprise Console) installed on the Jenkins Server
6. Connection from AppScan Source to AppScan Enterprise Console34

###Generating a Login Token
To generate an AppScan Source login token, execute the AppScan Source CLI, then log in with the following parameters:
`AppScan Enterprise Server URL, AppScan Source username, AppScan Source password -persist [-acceptssl]`

ex. `AppScanSrcCli.exe http://localhost:9443/asc myHostname\administrator appScanSourcePassword! -persist -acceptssl`

This will generate a file named ouncecli.token in the home directory of the user who executes the command.

For additional information, please see IBM's documentation:
http://www-01.ibm.com/support/knowledgecenter/SSS9LM_9.0.3/com.ibm.rational.appscansrc.utilities.doc/topics/command_line_interface_commands_login.html

###Configuring a Connection to AppScan Enterprise Console

A connection to your AppScan Enterprise Console must be configured from within AppScan Source  in order assessments can be published to AppScan Enterprise Server.  Follow the instructtions at the following link in order to complete this step.

http://www.ibm.com/support/knowledgecenter/en/SSS9LM_9.0.3/com.ibm.rational.appscansrc.security.doc/topics/preferences_ase.html

Note:  You may need to include the Fully Qualified Domain Name in the AppScan Enterprise Console Server URL to successfully configure the connection.

##Plugin Use:
###Install plugin

1. From the Jenkins main page, select Manage Jenkins
2. Select Manage Plugins
3. Click "Advanced"
4. Under Upload Plugin, choose the HPI file to upload (located in this project's "release" directory), then click "Upload"
5. Restart Jenkins

###Configure Plugin

1. From the Jenkins main page, select Manage Jenkins
2. Select Configure System
3. Under the AppScan Enterprise header, click "AppScan Source Installations"
    1. Provide the name of an installation (this is just for your reference later, in case you have more than one installation. This is to enable scanning on slaves where AppScan Source may be installed in a different location)
    2. Provide the installation directory for AppScan Source. The default location is: C:\Program Files (x86)\IBM\AppScanSource
4. Under the AppScan Enterprise Configuration header, complete the fields:
    1. AppScan Enterprise Hostname/Domain name is the server that AppScan Source logs into 
    2. Login Token File Path represents the location of the login token file generated above. This is the path on the Jenkins server.
    3. AppScan Enterprise Username is the user name of the account used to login to AppScan Enterprise Server
    4. AppScan Enterprise Password is the password of the account used to login to AppScan Enterprise Server
    5. AppScan Enterprise Console Hostname/Domain Name is the URL of the AppScan Enterprise Console
5. Click the "Test Connection" button.  If you receive the "Success" message, move forward with the next step.
6. Click the "Save" button at the bottom of the page

###Configure Job

1. Create a new job or access an existing job
2. Select "Configure"
3. Select "Add post-build action" and select "Publish to AppScan Enterprise"
4. Complete the fields that appear:
  1. AppScan Source installation will show the name you provided for the installation on the global configuration screen. If you have not added an installation, please go the the Jenkins Configure System link under Manage Jenkins. If you only have one installation configured, the installation should be selected for you. If you plan to execute AppScan Source on multiple Jenkins nodes, you may need to configure multiple installation paths.
  2. Disable scan should be unchecked if you wish the scan to run
  3. Accept SSL Errors should be checked if you have not created a trusted certificate for your AppScan Source installation. In an Enterprise environment, this should not be checked, since you should be using a trusted certificate.
  4. Select One will display a drop-down list of available folders on the AppScan Enterprise Server.  You should select the folder where the AppScan Source assessment will be published.
5. Click Save at the bottom
6. Run the job.

##Compatibility
This version of the plugin was tested with Jenkins 1.651.1 and IBM Security AppScan Source 9.0.3.  
