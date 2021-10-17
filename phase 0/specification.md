## Task 2 — Writing the specification

Once your group has decided on a domain, your first task is to develop a specification for the system you will be designing. We have provided a minimal list of requirements below to help ensure your specification is sufficiently rich to get started. We are looking for something of similar scale to the JShell case study specification from the Week 2 slides. There should be enough complexity that all of your group members have substantial work to do. Everyone should design and write code throughout the project! The following requirements are in terms of the layers of Clean Architecture, which are covered in Week 3.

- [x] at least three entity classes
- [x] at least two use case classes
- [x] at least one controller
- [x] at least a basic command line interface


Running the project that implements an HR system that allows the user in the company to access relevant information and status. Each user is either an employer or an employee. Each of them is associated with a username, a password, salary, attendance, and id. It should be able to get all users in the company and with their corresponding information: username, salary, attendance, and id. An employer should be able to set information for a particular employee, such as salary adjustment.

While running, the UI program prints an Intellij tab where users can give the following commands: create the personal profile for new employees, allow the employer to navigate through the directory structure they've built to view and change the profiles of employees he or she has created, allow employees to check their information such as salary and id, exit the system. We now have three entity classes: Employee, Employer and User. Two use case classes: SalaryManagement and Usermanager. Two controllers: SalarySystemController and UserSystemController. And one basic command-line user interface: UI.
