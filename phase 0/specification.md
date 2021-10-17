## Task 2 — Writing the specification

Once your group has decided on a domain, your first task is to develop a specification for the system you will be designing. We have provided a minimal list of requirements below to help ensure your specification is sufficiently rich to get started. We are looking for something of similar scale to the JShell case study specification from the Week 2 slides. There should be enough complexity that all of your group members have substantial work to do. Everyone should design and write code throughout the project! The following requirements are in terms of the layers of Clean Architecture, which are covered in Week 3.

- [x] at least three entity classes
- [x] at least two use case classes
- [x] at least one controller
- [x] at least a basic command line interface


Running the project that implements an HR system that allows the user in the company to access relevant information and status.

Each user is either an employer, an employee or an intern. Each of them is associated with a username, a password, salary and attendance.

It should be able to get all users in the company and their corresponding occupation and salary.

An employer should be able to set information for a particular employee or intern, such as salary adjustment or shift change.

While running, the UI program prints an Intellij tab where users can repeatedly type commands that
1. create the personal profile for new employees
2. allow the employer to navigate through the directory structure they've built to view and change the profiles of employees he or she has created.
3. allow employees to check their files(id, salary) including the salary details.
4. exit the system

In conclusion, we now have three entity classes: Employee, Employer and User. Three use case classes: SalaryManagement, Schedule and Usermanager. Two controllers: SalarySystemController and UserSystemController. And one basic command-line user interface: UI.
