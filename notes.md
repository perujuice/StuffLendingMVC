## Requirements

- Class diagram
- object diagram
- Sequence diagram 
- Best to probably use genmymodel.com

- We need to use the implementation principles(GRASP).
- We need to understand how to work with an architectural pattern (MVC) MODEL, VIEW and CONTROLLER.


## Implementation

### Classes

- Member class:
requirements: 
    - Create with a name, email and mobile phone number. A unique member id should be generated and assigned to the new member and the day of creation should be recorded.
        - The member id should be 6 alpha-numeric characters.
        - The email adress and phone number needs to be unique (no other members can have the same email or phone number).
    - Delete a member.
    - Change a member's information.
    - Look at a specific members full information.
    - List all members in a simple way (Name, email, current credits, and number of owned items)
    - List all members in a verbose way (Name, email, information of all owned items (including who they are currently lent to and the time period))

- Item class:
Requirements:
    - Create a new item for a member, the item should have a category (Tool, Vehicle, Game, Toy, Sport, Other), a name, a short description, the day of creation should be recorded, and a cost per day to lend the item.
        - When created the owning member gets 100 credits.
    - Delete an item
    - Change an item’s information.
    - View an items information including the contracts for an item (historical and future)
    
- Contract class:
Requirements:
    - Establish a new lending contract with a starting day, an ending day and an item.
        -Credits should be transfered according to the number of days and the price per day of the item
        - Can only be done if the lender has enough credits.
        - Can obly be done if the item is available during the time period

### Functional requirements

- we need to hard-code data for members and items to test that everything works in the end. 
- We need to figure our how to work with the time concepts:
    - Time is handled as a day counter, 0 is the first day and is set when the system starts. Time is not connected to the system in this proof of concept.
    - Advance day. In order to properly test the system there needs to be a way to advance the current day without relying on the system time


### MVC

model: The model will handle the backend information functionality and rules. In our case the Member, Item and Contract class (maybe a data handling class? )
controller: The controller will handle operation requested by the user such as deleting, adding or whatever. It takes info from the model and sends to the view to display it to the user.
view: The view will be responsilbe for displaying all information in the console to the user. Mostly handling print statements in this system I think.