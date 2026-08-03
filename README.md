# Project-3
Database Systems and Design Project 

Project overview: These users can add and delete courses and students, and register and drop courses for students. At the end of the semester, grades should be uploaded.

Constraints: 
- Students cannot register for a class twice for the same year and semester. 
- If a course is deleted, all registrations of that course need to be deleted too. (delete from registration table first, then delete it from the course table.)
- If a student is deleted from the system, all registrations of that student need to be deleted too. (delete from registration table first, then delete it from the student table.)

  
