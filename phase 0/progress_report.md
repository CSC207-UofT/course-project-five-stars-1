## Task 6 — Progress Report

Prepare a short written document updating your TA on your group's progress so far. At your next meeting with your TA, your group should be ready to present a summary of your progress report to your TA. Each group member must present part of the progress report.

- [x] a brief summary of your specification, CRC model, scenario walk-through, and skeleton program
- [x] open questions your group is struggling with
- [x] what has worked well so far with your design
- [x] a brief summary of what each group member has been working on and plans to work on next


1. brief summary of your specification, CRC model, scenario walk-through, and skeleton program

We are designing a program that keeps track of three different types of users in the HR system: the employer, the employee and interns. Each user is given an ID, username, password, salary and attendance value that is associated with them. The employer should be able to add new users or update user information in the system.
The SalaryManagement case class is used to track the monthly and yearly salaries of every user in the system using their IDs. The UserManager case class is used to access all the users in the system using their usernames and IDs. This means it allows new users to be added to the system and also verify the ID with the username of existing users. Both these classes can access any user in the system. The SalarySystemController uses the SalaryManagement case class and the UserSystemController uses the UserManager case class.

There are two situations to consider in the scenario-walkthrough: The Employer situation and the Employee situation. In the Employer situation, the employer uses the UserSystemController to register themselves and enter their details. Once registered, the employer will have access to all the employees information and also to the SalarySystemController which allows them to change employee salaries using the SalaryManagement case. The Employee situation allows the employee to change their password once they log in using the temporary login details. This takes them to a part of the system where they can see all their own information including salary amount and attendance.


2. open questions your group is struggling with
   For the UI system, the program offers the user multiple choices, but for each choice we have restrictions. For example, for one of the choices we expect you to enter a String, but if you enter an int, our program will tell you the answer entered is wrong, but it is not able to go back to the last step.
   Now every User data we entered is temporary, we want to find a way to store the data permanently so that the next time we rerun the program, we can access and edit the old User data.

3. what has worked well so far with your design
   So far, we have designed multiple entities(User, Employee and Employer) and implemented various methods in two controllers. We also implement a user-friendly interface in our UI part. This can allow our user to make registration by entering their personal information, access their information by entering their IDs, and check their monthly salary. We have also planned to construct some use cases like schedule and fireable. Besides, we also made a simple GUI system for users to use. On top of that, we also made enough test to test our code and ensure the codes remain of good quality.
