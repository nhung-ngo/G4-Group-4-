## Installation
- Get the project
    - clone

        `git clone https://github.com/nhung-ngo/G4-Group-4-
      
- Open the project in IntelliJ.
- switch the branch to "Final" branch
- [`/src/main/resources/application.properties`] file  is the configuration for the MySQL database on your localhost.
  - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `g4`.
  - You MUST have the database up and running before running the project! 
    - Open your XAMPP Control Panel.
    - Start the Apache server.
    - Start MySQL.
    - Click on MySQL "Admin" to open up the DBMS.
    - Ensure the database that you need is available.
- Build and run the main class.



## Instructions

### Log-in and sign-up
- We Can start with http://localhost:8080/users/login
- It will lead to login page for user.
- It will Have sign up link if not have an account.
### User
- After log-in, user will see the home page will services are displayed.
- User can view a service, comment on the service, or making reservation.
- User have booking history to check the pending booking, or booking history.
- User have profile page, and user is able to make edition like change password or change name or email.

### Provider
- User will see the switch to host button on the navigation bar. This allows user to host a service.
- If already have some services, provider can check service, make edition, delete service, or making replies.
- If not, there is create service button to create a new service.

### Admin
- Admin will have the different log-in page ( http://localhost:8080/admin/login )
- Default account for admin is: (username: admin , password: password)
- Admin will see statistic and manage users.
