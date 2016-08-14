This plugin requires:
1. AppScan Source installed on the Jenkins Server
2. AppScan Source application/project (PAF, PPF, etc.) artifacts on the Jenkins server
3. Source code and dependencies referenced in the AppScan Source artifacts on the Jenkins server
4. AppScan Source login token

To generate an AppScan Source login token, execute the AppScan Source CLI, then log in with the following parameters:
AppScan Enterprise Server URL, AppScan Source username, AppScan Source password -persist [-acceptssl] 
ex. AppScanSrcCli.exe http://vagrant-2012:9443/asc vagrant-2012\vagrant vagrant -persist -acceptssl
This will generate a file named ouncecli.token in the home directory of the user who executes the command.

For additional information, please see IBM's documentation:
http://www-01.ibm.com/support/knowledgecenter/SSS9LM_9.0.1/com.ibm.rational.appscansrc.utilities.doc/topics/command_line_interface_commands_login.html

Plugin Use:
Install plugin:
1. From the Jenkins main page, select Manage Jenkins
2. Select Manage Plugins
3. Click "Advanced"
4. Under Upload Plugin, choose the HPI file to upload, then click "Upload"
5. Restart Jenkins

Configure Plugin:
1. From the Jenkins main page, select Manage Jenkins
2. Select Configure System
3. Under the AppScan Source header, click "AppScan Source Installations"
a. Provide the name of an installation (this is just for your reference later, in case you have more than one installation. This is to enable scanning on slaves where AppScan Source may be installed in a different location)
b. Provide the installation directory for AppScan Source. The default location is: C:\Program Files (x86)\IBM\AppScanSource
4. Under the AppScan Source Configuration header, complete the fields:
a. AppScan Enterprise Hostname/Domain name is the server that AppScan Source logs into 
b. Login Token File Path represents the location of the login token file generated above. This is the path on the Jenkins server.
5. Click the "Save" button at the bottom of the page

Configure Job:
1. Create a new job or access an existing job
2. Select "Configure"
3. Select "Add build step" and select "Run AppScan Source"
4. Complete the fields that appear:
a. AppScan Source installation will show the name you provided for the installation on the global configuration screen. If you have not added an installation, please go the the Jenkins Configure System link under Manage Jenkins. If you only have one installation configured, the installation should be selected for you. If you plan to execute AppScan Source on multiple Jenkins nodes, you may need to configure multiple installation paths.
b. Disable scan should be unchecked if you wish the scan to run
c. Accept SSL Errors should be checked if you have not created a trusted certificate for your AppScan Source installation. In an Enterprise environment, this should not be checked, since you should be using a trusted certificate.
d. Scan Workspace Directory is where scan artifacts, like WAFL and staging files will be placed. Scan results (.ozasmt file) will also be placed in this directory.
e. Application file should point to a PAF or SLN file to scan.
5. Click Save at the bottom
6. Run the job.
