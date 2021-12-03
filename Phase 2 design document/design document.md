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
- Note: image of UML attached to the folder - Phase 2
- This UML shows connection between each package of the program, as well as individual classes within a package. For instance, UI uses both the Gateway and Controller package. Gateway and Controller uses Use Case package. Use Case uses Entity Package. THis means clean architecture is followed: more details later in section Clean Architecture. Within packages, the relationships between classes is also shown. For instance, we can see clearly all classes implements ReadWriter Interface in Gateway package. Similarly, Employee, Employer, and Intern are child classes of User in Entity package.


- [x] Major decisions
-	Our users are employees, employer, and interns. So we created a abstract class User, with child of Employee, Employer, and Intern. In addition, we have corresponding opeartional classes in Use Case, Gateway, and Controller package for Employee, Employer, and Intern.
-	In order to make our data storage flexible and enable pernanent data storage, we used serialization to store data, and realized this by creating a Gateway Package.
-	Only the employee has the authority to change an user information, and other users can create and modify the information.
-	Created ReadWrite Interface in the Gateway class so that all necesssary classes can implement it. Ensures all necessary methods are implemented.


- [x] Packaging Strategy
- We categorized our project files into five packages: Entity, UseCase, Controller, Gateway and User Interface. It was done so to create boundaries between classes, motivated by Single Responsibility Principle. We followed exactly the four layers by Clean Architecture: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI).

- [x] Clean Architecture

- For the clean architecture, we designed the system of our project based on what we learned from class. We divided the system into logical pieces and specify how those pieces communicate with each other. As you can see, we categorized our project files into five packages: Entity, UseCase, Controller, Gateway and User Interface. We followed exactly the four layers we learnt from class: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI). We also follow the dependency rule: Dependence on adjacent layer — from outer to inner, where the inner layers does not know the existance of the outer layer. Although dependency within the same layer is allowed, we tried to minimize coupling when designing program architecture. We ensured our project does not skip any layers while running.
  
- [x] SOLID

- Single Responsibility Principle
  We did good on this one. For example, in Entity folder, we use only one class to handle one single role (intern, employee, employer, user), such that every class   should have only a single responsibility. This is true to our controller folder as well, where each controller file contains one class that handle one specific     scenario, so that each class only have one reason to change.
- Open / Closed Principle:
  Our program is open for extenstion and closed for modification. We used a parent abstract User that have many child classes such as Employer, Employee, and Intern. In addition, all of our use cases does not use the child class directly, but uses User. This means our program is open for extension because if we add new User descendents – such as Security, Manger, and Appicants – nothing needs to be modified in the Use Case and the code still works, which is closed for modification.
- Liskov Substitution Principle:
  User can be substituted to Employer, Employee, and Intern without running into problems as the child classes didn’t remove or alter any features from the parent     class User. Similarily, Use case specific gateway implements ReadWrite Interface, which can be replaced by its child classes too.
- Interface Segregation Principle
  ReadWrite is a small interface, so that all class that implemented ReadWrite used all of its attributes.
- Dependency Inversion Principle:
  Followed clean architecture so that individual pieces are separated. For example, We modify Controllers, and it will never affect Use Case and Entities.

 
- [x] Design Patterns
- Template Design Pattern: It is significantly important for our group project. Our HR system includes the detailed information of tons of people(User). In order to avoid code duplication, we only want to create one class to represent any user inside of Entity. This class, called User, is the template that decides the main structure of any user. Then after this, we are free to create subclasses to override specific methods and add more features without changing its structure. Hence, we create different kinds of roles for the User in the company, such as Employer, Employee, Intern, Applicants, Manager, Security, and more. User with those roles are still part of User so they share the same properties as User. These are the subclasses that override the information of people (User superclass). The User superclass are the foundation of the entire HR system.
- Factory Design Pattern: There are many users in a HR system. We've added an UserFactory class in the entities. The UserFactory contains all types of users. When we want to create a User of a specific type, we just use the UserFacotory and specify our needs. This gives a more convenient implementation of classes in the Use Case Package by calling the UserFactory. Also, by doing this we obsure the creation process for these related users, which increases encapsulation and abstraction. In addition, using factory design pattern allows us to add more user types without interacting with other classes. This is closely related to Open / Closed Principle in SOLID.
- Builder Design Pattern: This is also significant for our group project. In many cases we used this design pattern to link our UI parts with Controller parts to achieve creating some complicate objects. For example, in order to show one's detailed information including his(or her) ID, weekly salary, and total salary, first we have a "director" class called "SalarySurface"(UI class) that refers to our "builder" interface. We also implement the "build" class called "SalarySystemController"(Controller class). This class implements "builder" interface by implementing a series of methods that can read and output the salary in the HashMap we create to store the ID with relevant salary, and show the yearly salary we compute. Then "SalarySurface" calls the method on "SalarySystemController" object to achieve the goals.
- Strategy Design Pattern: All the Use Case specific ReadWriter classes (such as UserReadWriter) in the Gateway Package only differ in their behaviour, but all have the same functionalities such as read and write serialized file. To avoid duplicate code and coupling, we introduced a Interface called ReadWriter in Gateway Package, which all other file reading and writing classes implement. This makes ReadWriter independent of a particular implementation of an algorithm, which makes later modification and extension much easier: Open / Closed Principle. 
- Future - Facade Design Pattern: We want our User to see their information together, and not separately in a case by case fashion, which is what we have currently. It might be a little coomplicated for users to use. So, we want to create a Facade class that ties together multiple Controllers in order to gather the information simultaneously. Then the GUI can directly utilize the Facade to display the user information, such as salary and schedule at the same time.
  
- [x] Progress Report
- Contribution of each member since phase 1
- Link to significant pull requests & Explanation
- Tian Shu: Wrote unit tests for Gateway Class, meaning more serialization files in the tests. Helped to formulate the design document. Pull requests: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/7#issue-1052760969 Creating database for the program using Serialization in teh Gateway Package. Note that I used the main branch most of the times so not everything was shown in this pull request. https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410 this is all pull request for all unit tests that I wrote for the Gateway class. 
- Canyang
- Shihan
- Yiteng
- Yuelin

- [x] Unit Testing
- All classes are tested, where each method has at least 1 corresponding unit test. Note: classes in UI not required to be tested.
- Link to pull request: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/14#issue-1052842072, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/15#issue-1052850708, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/17#issue-1052915473, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/19#issue-1053097978, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/20#issue-1053115867. Note that our tests are completed through various pull requests. Some of them are not shown because it is directly done in the main branch.
