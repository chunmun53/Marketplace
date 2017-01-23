Online Marketplace

The server file is MarketplaceServer.java and the client file is MarketplaceClient.java.

In the distributed system some machines have java version 7 and some machines have java version 8. So compile the program on machine with version 7.
Machine 10.234.136.56 has version 7.

To compile the program run the makefile on machine with version 7.

The port for RMI registry is set to 3000.

Run the RMI registry with port 3000 using the command
rmiregistry 3000&

The server machine is hardcoded as 10.234.136.56(in-csci-rrpc02.cs.iupui.edu).

Database has dummy user ids from 3 to 5 to check for remove user function.

To start the server for Java RMI run the MarketplaceServer file on machine 10.234.136.56(in-csci-rrpc02.cs.iupui.edu) using the command
java -cp ".:mysql-connector.jar" -Djava.security.policy=policy MarketplaceServer

Open an instance on any other machine

To start the client for Java RMI run the LoginView using the command
java -cp ".:mysql-connector.jar" -Djava.security.policy=policy LoginView

Kill rmi registry using below command to bring process to foreground
fg

The username for customer login is "Riddhi" and password is "123".

The username for admin login is "Admin" and password is "123".

Marketplace.java file works as an interface for the RMI

RequiresRole.java is declaring the annotation class

AuthorizationInvocationhandler.java checks the authorization condition.

ServerImpl.java is the implementaton of methods  files that were previously in server.

MarketplaceModel.java file works as the database for user details

DatabaseConnect.java file manages the connection with the database

LoginView.java file is the Login page where user enters username and password

MarketplaceServer.java file works as Server controller

MarketplaceClient.java works as the Client Controller

Session.java is the serializable session class

CustomerController.java is the customer controller

AdminController.java is the admin controller

AdminWelcome.java is the landing page for Admin role called from AdminController.

CustomerWelcome.java is the landing page for customer role called from CustomerController.

AddItem.java is the view page for adding items for admin.

PurchaseItems.java is the view page fo purchasing items for customer.

BrowseItem.java is the view for displaying product list for both customer and admin.

RemoveUser.java is the view to get the user id to delete.

RemoveItems.java is the view to get the product to remove from database by admin.

UpdateItems.java is the view to update product info for admin.

Dispatcher.java is the dispatcher file which decides where the control goes based on the user role

FrontController.java parses the parameters provided and issues a request with the MarketplaceClient to authenticate the data.

The Sample_Run.png file is a screenshot for the sample run

Makefile creates the class file for all the java files in the folder

Diagram.png is an image of the domain model diagram

Report.docx has the report summary for the assignment