Step 1: Download mysql Driver and then unzip the file.
Step 2: Add mysql Driver to eclips -
       * By right click on project
       * Go to **build path**
       * Next select **configure build path**
       * Select **labraries** on top icon
       * Select **Classpath**
       * Select **Add External JARs**
       * Select **Mysql Connector JAR file**
       * Click on **apply** and then finaly click on **apply and close**
Step 3: Create **database jdbc_database** 
Step 4: Create table **employee** and employee table consisting filds **id**, **name** & **salary** in the same order
        ex: create table employee(id int, name varchar(20), salary int);
Step 5: After all configuration and table creation is done then run the java application.
