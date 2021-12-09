## Task 6 — Progress Report

- [x] Specification

 - Running the HR system software allows the user in the company to access relevant information and status. Each user is either an employer, an employee or an intern. Each of them is associated with a username, a password, an email, a major, id, salary, schedule, and more. The software is capable of getting all users in the company and with their corresponding information: username, password, major, email and id, salary, schedule, and job position. An employer should be able to create account for an Intern and set salary, schedule, and job information for any users in the company. An intern can become an employee if he or she reaches the standard of promotion. Then, this intern would become an employee. 

 - While running, the UI package prompts user to a pop-up window where users can give the following commands: create the personal profile for users, allow the users to navigate through their stored information, so that they are able to view and change the profiles of users he or she has created, allow employees to check their information such as salary and id, allow Employers to create account for Intern, and exit the system. We have five entity classes: Employee, Employer, Intern, UserFactory and User; Five use case classes: SalaryManagement, UserManager, JobPosition, InternManager and WeeklySchedule; Five controllers: SalarySystemController, InternSystemController, ScheduleSystemController, JobSystemController and UserSystemController; six gateway classes: ReadWrite Interface, UserReadWriter; SalaryReadWriter, ScheduleReadWriter, InternReadWriter, and JobReadWriter; And one main user interface: GUI with six surfaces: InternSurface, JobSurface, LoginSurface, SalarySurface, ScheduleSurface and UserSurface. 

- [x] UML
- Note: image of UML attached to the folder - Phase 2 design document/uml.jpg
- This UML shows connection between each package of the program, as well as individual classes within a package. For instance, UI uses both the Gateway and Controller package. Gateway and Controller uses Use Case package. Use Case uses Entity Package. THis means clean architecture is followed: more details later in section Clean Architecture. Within packages, the relationships between classes is also shown. For instance, we can see clearly all classes implements ReadWriter Interface in Gateway package. Similarly, Employee, Employer, and Intern are child classes of User in Entity package.
- Phase 2 design document/class-specific example uml.jpg: a demo of scenario walk through of Users
- The User is an abstract class that have child of Employee, Employer, and Intern in the Entity. THen the UserManger in the Use Case package uses UserFactory and User in the Entity to store it as a collection i.e. ArrayList. Then the UserSystemController uses the UseManger for more variety of functionalities such as changing user information. Finally the UserSurface uses the UserSystemController to connect user input with user objects. Note that UserSurface also uses UserReadWriter, whcih implements ReadWriter, and has the capability of storing user information permanently.

- [x] Major Design Decisions
- Our users are employees, employer, and interns. So we created an abstract class User, with child of Employee, Employer, and Intern. In addition, we have corresponding operational classes in Use Case, Gateway, and Controller package for Employee, Employer, and Intern.
- In order to make our data storage flexible and enable permanent data storage, we used serialization to store data, and realized this by creating a Gateway Package.
- Only the employee has the authority to change a user information, and other users can create and modify the information.
- Created ReadWrite Interface in the Gateway class so that all necessary classes can implement it. Ensures all necessary methods are implemented.

- [x] Clean Architecture

- For the clean architecture, we designed the system of our project based on what we learned from class. We divided the system into logical pieces and specify how those pieces communicate with each other. As you can see, we categorized our project files into five packages: Entity, UseCase, Controller, Gateway and User Interface. We followed exactly the four layers we learnt from class: Enterprise Business Rules(Entity), Application Business Rules(UseCase), Interface Adapters(Controller, Gateways) and Frameworks & Drivers(UI). We also follow the dependency rule: Dependence on adjacent layer — from outer to inner, where the inner layers do not know the existence of the outer layer. Although dependency within the same layer is allowed, we tried to minimize coupling when designing program architecture. We ensured our project does not skip any layers while running.
  
- [x] SOLID

- Single Responsibility Principle
  We did good on this one. For example, in Entity folder, we use only one class to handle one single role (intern, employee, employer, user), such that every class   should have only a single responsibility. This is true to our controller folder as well, where each controller file contains one class that handle one specific     scenario, so that each class only have one reason to change.
- Open / Closed Principle:
  Our program is open for extension and closed for modification. We used a parent abstract User that have many child classes such as Employer, Employee, and Intern. In addition, all of our use cases does not use the child class directly, but uses User. This means our program is open for extension because if we add new User descendents – such as Security, Manger, and Applicants – nothing needs to be modified in the Use Case and the code still works, which is closed for modification.
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
- Factory Design Pattern: There are many users in an HR system. We've added an UserFactory class in the entities. The UserFactory contains all types of users. When we want to create a User of a specific type, we just use the UserFactory and specify our needs. This gives a more convenient implementation of classes in the Use Case Package by calling the UserFactory. Also, by doing this we obscure the creation process for these related users, which increases encapsulation and abstraction. In addition, using factory design pattern allows us to add more user types without interacting with other classes. This is closely related to Open / Closed Principle in SOLID.
- Builder Design Pattern: This is also significant for our group project. In many cases we used this design pattern to link our UI parts with Controller parts to achieve creating some complicate objects. For example, in order to show one's detailed information including his(or her) ID, weekly salary, and total salary, first we have a "director" class called "SalarySurface"(UI class) that refers to our "builder" interface. We also implement the "build" class called "SalarySystemController"(Controller class). This class implements "builder" interface by implementing a series of methods that can read and output the salary in the HashMap we create to store the ID with relevant salary, and show the yearly salary we compute. Then "SalarySurface" calls the method on "SalarySystemController" object to achieve the goals.
- Strategy Design Pattern: All the Use Case specific ReadWriter classes (such as UserReadWriter) in the Gateway Package only differ in their behaviour, but all have the same functionalities such as read and write serialized file. To avoid duplicate code and coupling, we introduced a Interface called ReadWriter in Gateway Package, which all other file reading and writing classes implement. This makes ReadWriter independent of a particular implementation of an algorithm, which makes later modification and extension much easier: Open / Closed Principle. Also, this follows Interface Segregation Principle as the ReadWriter Interface is small and all classes that implements it requires all methods defined by ReadWriter.
- Future - Facade Design Pattern: We want our User to see their information together, and not separately in a case by case fashion, which is what we have currently. It might be a little complicated for users to use. So, we want to create a Facade class that ties together multiple Controllers in order to gather the information simultaneously. Then the GUI can directly utilize the Facade to display the user information, such as salary and schedule at the same time.
  
- [x] Progress Report of Members
- Tian Shu: Wrote unit tests for Gateway Class, meaning more serialization files in the tests. Helped to formulate the design document. Pull requests: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/7#issue-1052760969 Creating database for the program using Serialization in teh Gateway Package. Note that I used the main branch most of the time so not everything was shown in this pull request. https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410 this is all pull request for all unit tests that I wrote for the Gateway class. 
- Canyang : 
- Since I fogot to make pull request and I only committed to the github, thus I copy paste some of my commit link below to demonstrate some main contributions about our group project.
- Fixing Gui and fixing the main code problem:
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/1991647d62963cfd14f5fe021dcc4d0ba287218d
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/e691f2cd9db38c7c5e2bf651dc59111006d5e594
- Write the code for entity, usecase, controller and GUI:
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/f20013782a76a713457c1253edbf8959d41c6d52
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/55876f4fc3c8a66f6bf8cb78628d339203fecac8
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/155af693b38743d4c2a30f441ceb9ef17dd6c1fe
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/a99ab2b20899dc0afa7142de0cf9260fb87db93d
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/17529b02c97cbded2c7e3e133c1fca9f0b6ae992
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/be86621cfab9ca2aef58eb0b58062e16231848fd
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/e4136fda38a422bc499bc180fc5e2283e3d20592
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/f63a3232b813e616f2e9ecc0a8556b3d311d0766
https://github.com/CSC207-UofT/course-project-five-stars-1/commit/b08708d68d93b4f0f2734401499243eff114c60a
- Shihan: 
All I have done so far are tests. Every pull requests under my name on Github is about tests and I always made a pull request after each time I completed one test. The following link contains two test for controllers. Other pull requests are also tests but only contains one test. 
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/19#issue-1053097978
- link for other tests:
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/11#issue-1052789623
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/12#issue-1052807218
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/13#issue-1052833098
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/14#issue-1052842072
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/15#issue-1052850708
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/16#issue-1052854427
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/17#issue-1052915473
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/18#issue-1053047433
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/20#issue-1053115867
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/21#issue-1053618098
https://github.com/CSC207-UofT/course-project-five-stars-1/pull/38#issue-1070254487
- Yiteng: 
- Wrote some use cases, entities, controllers. For example: Intern(entity), InternManager(use case), and InternSystemController(controller). Commit: https://github.com/CSC207-UofT/course-project-five-stars-1/commit/a332bc53b44d05a9f8fa04fb2f2f13fdd1d959c8, https://github.com/CSC207-UofT/course-project-five-stars-1/commit/5b25b898c463404c93ea8fb024206925f48d10ad, https://github.com/CSC207-UofT/course-project-five-stars-1/commit/59a43842bda47624554aa56b68dd76dcc6089e69, https://github.com/CSC207-UofT/course-project-five-stars-1/commit/215ae16f87d9f9b5665946453c1a84218e531cc1. 
- Wrote some unit tests for Intern, InternManager, and InternSystemController. Commit: https://github.com/CSC207-UofT/course-project-five-stars-1/commit/be024572f69bc0824ba64f759bb46315fb758572, https://github.com/CSC207-UofT/course-project-five-stars-1/commit/8d05bf6fb4951b5da54742d3a60313b6e3b86225 (Sorry for the inconvenience that in Phase 1 I did not make the pull request, all the time I use commit and push to the main branch.)
- Yuelin:  Wrote some features and enhance exist features to increase the quality of user experience. Created and implement the design document. Added design patterns and solid design principles and fixed the document base on the Phase 1 report feedbacks. Wrote Clean Architecture and Accessibility md file. Pull requests: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/4#issue-1052569192 Added the button feature to each of the user interfaces so that the user can always go back to the last page viewed, and moreover we can use this feature to test our system without restarting it again when we test it.
- Mihir: Debugged some errors and polished code. Created and worked on implemented intern leave days based on Phase 1 feedback. Edited Intern entity to include parameter for leave days. Working on creating GUI to include leave days. https://github.com/CSC207-UofT/course-project-five-stars-1/pull/42#issue-1071681291

- [x] Unit Testing
- All classes are tested, where each method has at least 1 corresponding unit test. Note: classes in UI not required to be tested.
- Link to pull request: https://github.com/CSC207-UofT/course-project-five-stars-1/pull/26#issue-1065115410, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/14#issue-1052842072, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/15#issue-1052850708, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/17#issue-1052915473, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/19#issue-1053097978, https://github.com/CSC207-UofT/course-project-five-stars-1/pull/20#issue-1053115867. Note that our tests are completed through various pull requests. Some of them are not shown because it is directly done in the main branch.
- For Entity, we compared the output for the method and the string we expected. We will provide the expected sting in our test.
- For the Use case, we will compare the output for the method in Usecase and the output from the entity method. Since we wrote a use case based on the entity, everything is correct if they generate the same result.
- For the Controller, a similar process as we did in the use case. Compared between the output for the method in Usecase and the output from the Controller. Since we wrote Controller based on the Use case, everything is correct if they generate the same result.
- For gateway, we created two test files for each method, one using our implemented method, another using standard serialization. Then we compared the two serialized objects after converting them back to a java object.
- In addition, for the methods may produce multiple outputs, our tests covered all the possible outputs and we passed these tests.
- Also for the methods containing strings, we import java.io.ByteArrayOutputStream and java.io.PrintStream to check the output string are what we expect.
- We didn't ReadWriter Interface as interface can not instantiate methods.
- We didn't test the User class as most of its major functionalities are not implemented and are overriden in the child classes.

- [x] Use of GitHub Features: 
- Created Branches of our own to work locally.
- Used pull requests and merge when necessary.
- Used issues to address questions to be solved.
- Able to work together efficiently and simultaneously.

- [x] Code Style and Documentation
- No warnings and errors related to style
- All classes are well documented using JavaDoc
- Java programmer should be able to understand your code easily because of our neat organization.

- [x] Refactoring and Code Smell
- Some of us used branches with pull requests to work on project simultaneously and refactor different parts of the program.
- Refactored naming conversions from Phase 1.
- Refactored function in the UI package using lambda.
- Catches all exceptions in the UI package so the program doesn't crash when users input an incorrect value: i.e. enter float when int is required.
- All code smells are solved

