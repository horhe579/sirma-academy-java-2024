
# My Solution To The Sirma Final Exam

A brief description of what this project does and my understanding of it




## Day 1
Spent the first day thinking of how the project is going to be structured, copied most of the functionality from my CSV parser from the Employees project and changed it so it works with the files that were attached to the task(did not finish completely)

## Day 2
Created entities to match the rows in the CSV files, the entities were as follows:



- Team Entity
- Match Entity
- Player Entity
- Record Entity

All of them had the needed fields, I added some checks using Hibernate validation and defined the relations between the tables

## Day 3
Managed to implement all of the CSV parsers which use a common interface that has 3 methods - one to read the file line by line, one to parse a line and create the according object and one to save a batch. I save batches since I do not want to stress my computer with over 1100 entries and in each parser I have defined a batch size, that once reached after parsing enough lines calls the save batch method which takes a collection of entries. The parse method takes a line and makes sure it is in the correct format and if it has a reference to another table it makes sure it is a valid one, if a line is invalid the method returns NULL and does not get added to the list of entries that get saved.

The API as of right now works on the following principle:
A hardcoded file path for each CSV lies in my code, and once I visit the endpoint "/test" and make a GET req. all of the CSV files are parsed and loaded in the DB.

I also used @Transactional annotation on the save batch method to make sure if something goes wrong no data is saved halfway.

I had a minor problem with @GeneratedValue annotation, since when I tried to change the CSV files to contain faulty lines, they do not get saved and the IDs I set in the constructor get overriden by the annotation, messing up the relations completely. I removed the annotation since the answers on Stack Overflow to override the GenerationStrategy didn't seem to work.

Implementing the algorithm for getting the pair of players is left for the next day, since I have to think it out.

I started working on the CRUD operations and defined all the needed services and controllers. I started with the Team creation since it does not have any relations, and had to implement a custom Id Generator, I defined an interface and a Service class that works for all of the 4 classes(I think) and implemented the C of CRUD for Teams, then i realized when parsing the CSV after creating a entry using the controller I do not check if the ID in the line already exists in the DB so I defined a custom function in the repository.

So far I have managed to take care of these concerns:

- Parsing the CSV files
- Maintaining data integrity
- Not using an external CSV parsing library
- Using an SQL DB
- Taking care of field validation
- And handling some edge cases
