## Task 6 — Progress Report

- [x] Specification

 - Running the project that implements an HR system that allows the user in the company to access relevant information and status. Each user is either an employer, an employee or an intern. Each of them is associated with a username, a password, salary, attendance, and id. It should be able to get all users in the company and with their corresponding information: username, salary, attendance, and id. An employer should be able to set information for a particular employee, such as salary adjustment.  An intern can become an employee if he/she reaches the standard of promotion. Then, this intern would be added into the user of the employee. On top of that, we also want to implement an interface called fireable which is used to consider if an employee or intern will fire or not based on their performance.

 - While running, the UI program prints an Intellij tab where users can give the following commands: create the personal profile for new employees or intern, allow the employer or intern to navigate through the directory structure they've built to view and change the profiles of employees he or she has created, allow employees or intern to check their information such as salary and id, exit the system. We now have three entity classes: Employee, Employer and User. Two use case classes: SalaryManagement and Usermanager. Two controllers: SalarySystemController and UserSystemController. And one basic command-line user interface: UI. In the next phase, we want to add another entity called intern, another interface called fireable and also another controller which is internController. After that, re-modifying our GUI is inevitable and we will also add the intern in it.



- [x] Scenario Walk-Through


  Employer Scenario:

  Firstly, employer uses this HR system and the system shows him the log-in page using the UserSystemController. Register himself through the registration button UserManager use case, we will need to enter his ID, username, password, salary, and attendance. After he successfully registered himself, the system will send him back to the login page. When the employer login, he can change put employee’s salary, add new Interns in the company and he can also check for the schedule about himself. Noticed that only the employer has the authorization to create an Intern account. (So far, everyone can create a User since our code did not add the restriction on different users’ rights.)


  Employee Scenario:
    An employee who is recruited by an employer should register his username, temporary password, major and email by themself. The system will show the employee the log-in page, he will use his username and password to login in.  We believe the first time the employee logs in, the system will show him/her 5 options, salary, jobposition, intern, schedule and exit, he/she can choose one of them but they don’t have rights to do some of the function in these option. The employee logs in to the system and he can see his profile page, he now can see all his personal information including the detailed components of his salary and the reference job position.

  Intern Scenario:
    Firstly,  only employer can edit the detailed information of interns. Employees and interns can not change the information. The system will check their IDs to judge whether he(or she) is an employer.
Employer needs to add the detailed information of one intern and his (or her) internship grade to our HR System.
Next, The employer can enter the standard grade to select the interns that their grades exceed the standard grade. Their will be accepted as our employees.
After the grading, interns can check their accepting status by entering their IDs.


- [x] UML
- ![alt text](https://github.com/CSC207-UofT/course-project-five-stars-1/blob/main/uml.jpg?raw=true)
- 
- The UML shows connection between 


- [x] Description of major decisions

  ?????????????????????????




- [x] Packaging Strategy

- [x] Clean Architecture

- For the clean architecture, we designed the system of our project based on what we learned from class. We divided the system into logical pieces and specify how those pieces communicate with each other. As you can see, we categorized our project files into five packages: Entity, UseCase, Controller, Gateway and User Interface. We followed exactly the four layers we learnt from class: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI). We also follow the dependency rule: Dependence on adjacent layer — from outer to inner, where the inner layers does not know the existance of the outer layer. Although dependency within the same layer is allowed, we tried to minimize coupling when designing program architecture. We ensured our project does not skip any layers while running.
  
- [x] SOLID

- Single Responsibility Principle
  We did good on this one. For example, in Entity folder, we use only one class to handle one single role (intern, employee, employer, user), such that every class   should have only a single responsibility. This is true to our controller folder as well, where each controller file contains one class that handle one specific     scenario, so that each class only have one reason to change.
- Open / Closed Principle:
  Our program is open for extenstion and closed for modification. We used a parent abstract User that have many child classes such as Employer, Employee, and Intern. In addition, all of our use cases does not use the child class directly, but uses User. This means our program is open for extension because if we add new User descendents such as Security, nothing needs to be modified in the Use Case and the code still works, which is closed for modification.
- Liskov Substitution Principle:
  User can be substituted to Employer, Employee, and Intern without running into problems as the child classes didn’t remove or alter any features from the parent     class User. Similarily, Use case specific gateway implements ReadWrite Interface, which can be replaced by its child classes too.
- Interface Segregation Principle
  ReadWrite is a small interface, so that all class that implemented ReadWrite used all of its attributes.
- Dependency Inversion Principle:
  Followed clean architecture so that individual pieces are separated. For example, We modify Controllers, and it will never affect Use Case and Entities.

 
- [x] Design Patterns

  The template design pattern is significantly important for our group project. Our hr system includes the detailed information of tons of people(User). In order to avoid code duplication, we only want to create one class to represent User inside of Entity,  this class is the template that decides the main structure of User, then after this, we are free to create subclasses to override specific steps of the algorithm without changing its structure. So we create different kinds of roles for the User in the company, such as manager, boss, employee and applicants, User with those roles are still part of User so they share the same properties as User. These are the subclasses that override the information of people(User superclass). The User superclass are the foundation of the whole hr system.
  ??????????????????????????????????????????????????? One more pattern
  
  
- [x] Progress Report
- Contribution of each member since phase 1
- Link to significant pull requests & Explanation
- summary of group member's contribution

- [x] Unit Testing
- All classes are tested, where each method has at least 1 corresponding unit test.
- Link to pull request:
