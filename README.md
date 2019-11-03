# Library
Library application for finding books and users, adding new book lendings and getting reports for overdue lendings.

Application is based on Spring Boot and is using H2 in memory database which console is available at /h2-console.

REST api endpoints:

- GET api/books
- POST api/books with new Book object (title, author, amount, sectionInLibrary)
- DELETE api/books/{id}
- GET api/reports for getting all overdue lendings
- GET api/books/search with "search" parameter - part of book's name or author.
- POST api/lendings with new Lending object (Person object with Id; Book object with Id; 
lendingDate (format: "yyyy-MM-dd"))
- POST api/peopleInRoles with new personInRole object (Person object with name and email; 
Role object with Id; startDate (format: "yyyy-MM-dd")) to add new Person with an existing role.
- GET api/people/search with "search" parameter - part of person's name or email.

Some roles and books are initially added from data.sql.

