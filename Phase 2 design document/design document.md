## Task 6 — Progress Report

Prepare a short written document updating your TA on your group's progress so far. At your next meeting with your TA, your group should be ready to present a summary of your progress report to your TA. Each group member must present part of the progress report.

- [x] SOLID


-From solid design principles,  our project includes most of the five basic principles of object-oriented design as required: Single responsibility principle (SRP), Liskov substitution principle (LSP), Interface segregation principle (ISP) and the Dependency inversion principle (DIP). And we followed the requirements of those principles successfully.


- Single Responsibility Principle
  We did good on this one. For example, in Entity folder, we use only one class to handle one single role (intern, employee, employer, user), such that every class should have only a single responsibility. This happens to our controller folder as well, each controller file contains one class that handle one specific scenario, so each class only have one reason to change.
- Liskov Substitution Principle:
  Employer, Employee, and Intern extended from User and didn’t remove or alter any features
  Use case specific gateway implements ReadWrite Interface, and only extended.
- Interface Segregation Principle
  ReadWrite is a small interface, so that all class that implemented ReadWrite used all of its attributes
- Dependency Inversion Principle:
  Followed clean architecture so that individual pieces are separated
  For example, We modify Controllers, and it will never affect Use Case and Entities



- [x] Specification

 - Running the project that implements an HR system that allows the user in the company to access relevant information and status. Each user is either an employer, an employee or an intern. Each of them is associated with a username, a password, salary, attendance, and id. It should be able to get all users in the company and with their corresponding information: username, salary, attendance, and id. An employer should be able to set information for a particular employee, such as salary adjustment.  An intern can become an employee if he/she reaches the standard of promotion. Then, this intern would be added into the user of the employee. On top of that, we also want to implement an interface called fireable which is used to consider if an employee or intern will fire or not based on their performance.

 - While running, the UI program prints an Intellij tab where users can give the following commands: create the personal profile for new employees or intern, allow the employer or intern to navigate through the directory structure they've built to view and change the profiles of employees he or she has created, allow employees or intern to check their information such as salary and id, exit the system. We now have three entity classes: Employee, Employer and User. Two use case classes: SalaryManagement and Usermanager. Two controllers: SalarySystemController and UserSystemController. And one basic command-line user interface: UI. In the next phase, we want to add another entity called intern, another interface called fireable and also another controller which is internController. After that, re-modifying our GUI is inevitable and we will also add the intern in it.



- [x] Indication of how to run the code

  ???????????????????????????????


- [x] Description of major decisions

  ?????????????????????????



- [x] Clean Architecture

- 
  For the clean architecture, we design the system of our project based on what we learned from class. We divided the system into logical pieces and specify how those pieces communicate with each other. As you can see, we categorized our project files into five files: Entity, UseCase, Controller, Gateway and User Interface. We followed exactly the four layers we learnt from class: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI). Also, we not only follow the categorized rules but also we also follow the dependency rule: Dependence on adjacent layer — from outer to inner, Dependence within the same layer is allowed  (but try to minimize coupling). We make sure our project does not skip any layers while running.


- Scenario Walk-Through


  Employer Scenario:

  Firstly, employer uses this HR system and the system shows him the log-in page using the UserSystemController. Register himself through the registration button UserManager use case, we will need to enter his ID, username, password, salary, and attendance. After he successfully registered himself, the system will send him back to the login page. When the employer login, he can change put employee’s salary, add new Interns in the company and he can also check for the schedule about himself. Noticed that only the employer has the authorization to create an Intern account. (So far, everyone can create a User since our code did not add the restriction on different users’ rights.)


  Employee Scenario:
    An employee who is recruited by an employer should register his username, temporary password, major and email by themselves. The system will show the employee the log-in page, he will use his username and password to login in.  We believe the first time the employee logs in, the system will show him/her 5 options, salary, jobposition, intern, schedule and exit, he/she can choose one of them but they don’t have rights to do some of the function in these option. The employee logs in to the system and he can see his profile page, he now can see all his personal information including the detailed components of his salary and the reference job position.

  Intern Scenario:
    Firstly,  only employer can edit the detailed information of interns. Employees and interns can not change the information. The system will check their IDs to judge whether he(or she) is an employer.
Employer needs to add the detailed information of one intern and his (or her) internship grade to our HR System.
Next, The employer can enter the standard grade to select the interns that their grades exceed the standard grade. Their will be accepted as our employees.
After the grading, interns can check their accepting status by entering their IDs.





- [x] Design Patterns

  The template design pattern is significantly important for our group project. Our hr system includes the detailed information of tons of people(User). In order to avoid code duplication, we only want to create one class to represent User inside of Entity,  this class is the template that decides the main structure of User, then after this, we are free to create subclasses to override specific steps of the algorithm without changing its structure. So we create different kinds of roles for the User in the company, such as manager, boss, employee and applicants, User with those roles are still part of User so they share the same properties as User. These are the subclasses that override the information of people(User superclass). The User superclass are the foundation of the whole hr system.
  
  ??????????????????????????????????????????????????? One more pattern
  

- [x] Use of GitHub Features

  Created Branches of our own to work locally
  pull requests and merge when necessary
  → able to work together efficiently and simotaneously


- [x] Code Style and Documentation

  No, in Intellij, there are only a few warnings related to more features that we plan to extend. Other than that, all there are no warnings related to styles and etc.

  Yes! Javadoc is used where needed.

  Yes! If a Java programmer were to open your repo and navigate to a random file, they would be able to understand your code.


- [x] Testing

  Yes, most components of our system are tested. The user interface components would be difficult to test due to your design, but we will find a way to test it later.
  All test files are under:  src / test


- [x] Refactoring

  Yes, there is evidence that your team has refactored code in a meaningful way during the project.
  After phase0, we reorganized all the codes and seperated them into five folders. In each of the folders, we created more files where each file handle a specific scenerio. But at that time, we did not know how to use pull request, so you may not be able to find it thought requests.
  For phase 1, some of us used branches with pull requests to work on project simitaneously and refactor different parts of the program.
  For code smells, some of our entity have relative long parameters, we may fix this in the future by giving default values.




- [x] Code Organization Functionality

Is your code organized in a meaningful way? Is it easy to find things in your package structure? Tell us about how you decided to organize your code and why!
  Organized code into packages according to clean architecture
  inner most layer: entities
  second layer: use case
  third layers: gateway and controllers
  outer most layer: user interface
able to change outer layers without interfering inner layers



- [x] Functionality

Does your program do what the specification says it should do?
  Yes, can can be extended to add more features such as fire and recruit
Demo your program's functionality to your TA or make a short video!
  Live demo
Is the functionality sufficiently ambitious, given the size of your group?
  Of course
Can your program store state and load state? I.e. Can the state persist across runs of your program?
  Yes, data are being stored perminantly in relative paths in txt files using serialization


- [x] Design Document

Is all of the above discussed in an organized way?
  Definitely
Does your design document convince your team that you deserve the grade you are hoping to earn?
  Of course
If it does, then it will likely convince your TA too!
  :)


- [x] Teammate Contribution and Plan