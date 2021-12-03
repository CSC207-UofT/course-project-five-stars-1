## Task 6 — Progress Report

- [x] Specification

 - Running the HR system software allows the user in the company to access relevant information and status. Each user is either an employer, an employee or an intern. Each of them is associated with a username, a password, an email, a major, id, salary, schedule, and more. The software is capable of getting all users in the company and with their corresponding information: username, password, major, email and id, salary, schedule, and job position. An employer should be able to create account for an Intern and set salary, schedule, and job information for any users in the company. An intern can become an employee if he orshe reaches the standard of promotion. Then, this intern would become an employee. 

 - While running, the UI package prompts user to a pop up window where users can give the following commands: create the personal profile for users, allow the users to navigate through their stored information, so that they are able to view and change the profiles of users he or she has created, allow employees to check their information such as salary and id, allow Employers to create account for Intern, and exit the system. We have five entity classes: Employee, Employer, Intern, UserFactory and User; Five use case classes: SalaryManagement, Usermanager, JobPosition, InternManager and WeeklySchedule; Five controllers: SalarySystemController, InternSystemController, ScheduleSystemController, JobSystemController and UserSystemController; six gateway classes: ReadWrite Interface, UserReadWriter; SalaryReadWriter, ScheduleReadWriter, InternReadWriter, and JobReadWriter; And one main user interface: GUI with six surfaces: InternSurface, JobSurface, LoginSurface, SalarySurface, ScheduleSurface and UserSurface. 

- [x] UML
- Note: image of UML attached to the folder - Phase 2
- This UML shows connection between each package of the program, as well as individual classes within a package. For instance, UI uses both the Gateway and Controller package. Gateway and Controller uses Use Case package. Use Case uses Entity Package. THis means clean architecture is followed: more details later in section Clean Architecture. Within packages, the relationships between classes is also shown. For instance, we can see clearly all classes implements ReadWriter Interface in Gateway package. Similarly, Employee, Employer, and Intern are child classes of User in Entity package.


- [x] Major Design Decisions
-	Our users are employees, employer, and interns. So we created a abstract class User, with child of Employee, Employer, and Intern. In addition, we have corresponding opeartional classes in Use Case, Gateway, and Controller package for Employee, Employer, and Intern.
-	In order to make our data storage flexible and enable pernanent data storage, we used serialization to store data, and realized this by creating a Gateway Package.
-	Only the employee has the authority to change an user information, and other users can create and modify the information.
-	Created ReadWrite Interface in the Gateway class so that all necesssary classes can implement it. Ensures all necessary methods are implemented.

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

- [x] Packaging Strategy
- We categorized our project files into five packages: Entity, UseCase, Controller, Gateway and User Interface. It was done so to create boundaries between classes, motivated by Single Responsibility Principle. We followed exactly the four layers by Clean Architecture: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI).
 
- [x] Design Patterns
- Template Design Pattern: It is significantly important for our group project. Our HR system includes the detailed information of tons of people(User). In order to avoid code duplication, we only want to create one class to represent any user inside of Entity. This class, called User, is the template that decides the main structure of any user. Then after this, we are free to create subclasses to override specific methods and add more features without changing its structure. Hence, we create different kinds of roles for the User in the company, such as Employer, Employee, Intern, Applicants, Manager, Security, and more. User with those roles are still part of User so they share the same properties as User. These are the subclasses that override the information of people (User superclass). The User superclass are the foundation of the entire HR system.
- Factory Design Pattern: There are many users in a HR system. We've added an UserFactory class in the entities. The UserFactory contains all types of users. When we want to create a User of a specific type, we just use the UserFacotory and specify our needs. This gives a more convenient implementation of classes in the Use Case Package by calling the UserFactory. Also, by doing this we obsure the creation process for these related users, which increases encapsulation and abstraction. In addition, using factory design pattern allows us to add more user types without interacting with other classes. This is closely related to Open / Closed Principle in SOLID.
- Builder Design Pattern: This is also significant for our group project. In many cases we used this design pattern to link our UI parts with Controller parts to achieve creating some complicate objects. For example, in order to show one's detailed information including his(or her) ID, weekly salary, and total salary, first we have a "director" class called "SalarySurface"(UI class) that refers to our "builder" interface. We also implement the "build" class called "SalarySystemController"(Controller class). This class implements "builder" interface by implementing a series of methods that can read and output the salary in the HashMap we create to store the ID with relevant salary, and show the yearly salary we compute. Then "SalarySurface" calls the method on "SalarySystemController" object to achieve the goals.
- Strategy Design Pattern: All the Use Case specific ReadWriter classes (such as UserReadWriter) in the Gateway Package only differ in their behaviour, but all have the same functionalities such as read and write serialized file. To avoid duplicate code and coupling, we introduced a Interface called ReadWriter in Gateway Package, which all other file reading and writing classes implement. This makes ReadWriter independent of a particular implementation of an algorithm, which makes later modification and extension much easier: Open / Closed Principle. 
- Future - Facade Design Pattern: We want our User to see their information together, and not separately in a case by case fashion, which is what we have currently. It might be a little coomplicated for users to use. So, we want to create a Facade class that ties together multiple Controllers in order to gather the information simultaneously. Then the GUI can directly utilize the Facade to display the user information, such as salary and schedule at the same time.
  
- [x] Progress Report of Members
- Tian Shu: Wrote unit tests for Gateway Class, meaning more serialization files in the tests. Helped to formulate the design document. Pull requests: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/7#issue-1052760969 Creating database for the program using Serialization in teh Gateway Package. Note that I used the main branch most of the times so not everything was shown in this pull request. https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410 this is all pull request for all unit tests that I wrote for the Gateway class. 
- Canyang
- Shihan
- Yiteng
- Yuelin

- [x] Unit Testing
- All classes are tested, where each method has at least 1 corresponding unit test. Note: classes in UI not required to be tested.
- Link to pull request: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/14#issue-1052842072, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/15#issue-1052850708, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/17#issue-1052915473, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/19#issue-1053097978, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/20#issue-1053115867. Note that our tests are completed through various pull requests. Some of them are not shown because it is directly done in the main branch.

- [x] Use of Github Features: 
- Created Branches of our own to work locally.
- Used pull requests and merge when necessary.
- Used issues to address questions to be solved.
- Able to work together efficiently and simotaneously.

- [x] Code Style and Documentation
- No warnings and erros related to style
- All classes are well documented using JavaDoc
- Java programmer should be able to understand your code easily because of our neat organization.

- [x] Refactoring and Code Smell
- Some of us used branches with pull requests to work on project simitaneously and refactor different parts of the program.
- Refactored naming convensions from Phase 1.
- Refactored function in the UI package using lambda.
- All code smells are solved

