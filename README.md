# Research Paper Management - OOADJ project


## Team members:
1.
Shishir Hegde
PES1UG20CS396
2.
Shreyas Kaundinya
PES1UG20CS409
3.
Shrinithi Natarajan
PES1UG20CS413
4.
Siddharth Soora
PES1UG20CS426


## Synopsis:
This research paper management portal handles and manages everything related to research papers. From the process of being a user for searching and viewing a paper, to logging in as an author and publishing a paper, or being a panel member at a conference who reviews the papers, all sorts of dynamics are established in the project. Users can search and view papers, so can the authors. The panel members can review, edit and approve papers. There is also a conference admin who is in charge of creating and scheduling conferences where the papers that have been submitted can be reviewed by the panellists.
All of the features have been implemented using a simple login interface to access the required functionality. We have also implemented user authorization in our login interface where a user can signup and login either as a General User, an Author, a Conference Admin or a Panel Member.

We have added functionalities for each kind of user too:
The General User can sign up as a User and log in to search for any paper or conference to view and gain knowledge from.
The Author can sign up as an Author and log in to write and publish papers, along with cite other papers in the portal and read reviews given about the paper from the panellists (if the paper has been reviewed in a conference).
The Conference Admin can create and schedule the conferences that happen, where panellists can attend and review the papers submitted by the Authors who have registered for that particular conference.
The Panel Member can attend the conference as a panellist and review the paper and also provide certain comments about the paper which the author can see and act upon in their part of the portal.


## Use case diagram:

![image](https://user-images.githubusercontent.com/93257735/235209001-ac86c87c-8a33-4477-9f99-a7ffabfc915e.png)


## Class diagram

![image](https://user-images.githubusercontent.com/93257735/235209115-8bece0eb-952b-43d1-b095-e8422e2ee7b1.png)


## Design Principles:

Single Responsibility Principle- Each user role handles a single responsibility of creating objects or executing the use cases related to that particular user role. For example, there is a separate method for submitting a paper, reviewing a paper etc which can later be extensible to incorporate more features without having to modify too many classes.



## Design Patterns:

Singleton- The singleton pattern was implemented in the user login scenario. Only one user is assumed to be signed in in one system at a time. Hence we implemented a singleton pattern for the same





