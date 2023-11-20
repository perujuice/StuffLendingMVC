# Stuff lending System OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

## Detailed Design
### Class Diagram

![class diagram](img/class-diagram.jpeg)


### Sequence Diagram

![sequence diagram](img/sequence-diagram.jpeg)

This sequence diagram illustrates the method calls and communication between the objects when user creates a new member is creating a new member. The requirement for the sequence diagram is very vague so to our assumption this is simply the requirement, to merely show the process of adding one member by user input.


### Object Diagram
![object diagram](img/object_diagram.jpg)

The User interacts with the UserInterface to provide input and receive output.
The UserInterface communicates with the MemberManagement for user-related actions.
The MemberManagement interacts with the MemberController for member-related operations.
The MemberController may interact with the Member class to perform actions on member data.
The MemberController may also interact with the TimeManager class for time-related operations.
The App class oversees the overall flow of the application but is not directly connected to individual objects in this representation.