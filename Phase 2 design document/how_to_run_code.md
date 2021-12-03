- [x] Below are the steps to run the code


- Run the java class called "main" in the UI package. Then, a GUI wil be displayed and with a pop up window that enables user to enter Password, username, email and major. 

- Firstly, register an user by filling out the password, username, email, and major. Note that there are several restrictions on your registration. For example, the length of password should be at least 6, the length of username should be at least 1, and email needs to be a properly formatted like including "@" symbol only once, and a "." only once after "@" symbol. Also note that major is optional, and you can leave it empty for now. 

- In the same window, notice that there are also 2 buttons at the bottom called "register" and "login". After filling the required information, click register, since your information is never store in our program.


- After a successful registration with correct information, you can click on login. You will be assigned a random id from 1 to 10. An user id of 0 corresponds to the employer. The employer has many more authorities than a regular user, such as register account for an Intern, send wage to employees money, and more.

- Then, you will be prompted to the next window. There are five buttons which are Salary, JobPositions, Schedule, Intern and Exist. Click on any of those to explore further.

  - If you click the Salary button, you will be prompted to another window with 3 entrees:  UserID1, and UserID2, and Salary. The purpose of the winder is to allow user with UserID1 to change the salary of the user with UserID2. Only when UserID1 equal to 0 that your can edit the salary of the corresponding UserID2; otherwise, you have no authority to change the salary of user with userid 2. When the salary is correctly updated, the monthly, yearly, and after-tax salary will be shown for user with uUerID2 after you clik the "Set Salary" button. Click the button "Back" when done.

  - If you click the JobPosition button, you will be prompted to another window with 2 entrees: UserID and User Major. Type in your userid and update your UserMajor, then you can be referenced to a department base on your major. For example, you entered "computer science" you would get a reference as IT department based on your major. Note that and we only have a few major that can be referenced so far.

  - If you click the Schedule button, you will be prompted to another window with 2 entrees: UserID and Change Hour. The default working hour per week is 40 hours. When you want to change your working hour per week, enter the difference as an integer, then you can see the updated schedule entire week. 

  - If you click the Intern button, you will be prompted to another window with 7 entrees:  UserID, Password, Username, Email, Major, Grade, and Standard. This window is only available for employer to make modifications, meaning only when your userid is 0 that you have the authority to set up an information for your intern. You can give the intern a password, a username, an email, a major based on their own information. You can give them a grade based on his/her behavior and also the standard that you set up for them. Besides, after you register these information for them you can click Intern which will pop up an information says successful. Then, the intern will get a random id from 11 to 20.

  - Finally, you can click Exit button to close the window smoothly.
