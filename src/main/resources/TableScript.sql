drop database if exists library_db;
create database library_db;
use library_db;


create table author(
   author_id int auto_increment,
   name varchar(50) NOT NULL,
   mention varchar(500),
   constraint author_id_pk primary key (author_id)
);

create table genre(
	genre_id int auto_increment,
	genre varchar(30) not null,
	constraint genre_id_pk primary key (genre_id)
);

create table book(
   book_id int auto_increment,
   author_id int,
   genre_id int,
   title varchar(150),
   cover_url varchar(1000),
   synopsis varchar(5000),
   constraint book_id_pk primary key (book_id),
   foreign key (author_id) references author(author_id),
   foreign key (genre_id) references genre(genre_id)
);

insert into author (name, mention) values ('Brad Dayley', 'Javascript Angular Developer');
insert into author (name, mention) values ('Zac Gordan', 'Javascript React Developer');
insert into author (name, mention) values ('Cay S. Horstmann', 'Java SE 11 Fanatic');
insert into author (name, mention) values ('Herbert Schildt', 'Java/Oracle Developer');
insert into author (name, mention) values ('Adam D. Scott', 'Javascript Full Stack');
insert into author (name, mention) values ('Nader Dabit', 'Full Stack Serverless Developer');
insert into author (name, mention) values ('Devin Abott', 'Javascript React Native Fullstack');
insert into author (name, mention) values ('Adam Freeman', 'Old Class Based React');
insert into author (name, mention) values ('Ethan Brown', 'Javascript Node and Express');
insert into author (name, mention) values ('Craig Walls', 'Java Spring Boot');


insert into genre (genre) values ('Javascript/React');
insert into genre (genre) values ('Javascript/Angular/TypeScript');
insert into genre (genre) values ('Java');
insert into genre (genre) values ('Java/Spring Boot');
insert into genre (genre) values ('CSS/Bootstrap');
insert into genre (genre) values ('Serverless/AWS');
insert into genre (genre) values ('Javascript/Express/Node');

insert into book (author_id, genre_id, title, cover_url, synopsis) values (1, 2, 'Learning Angular', 'https://www.pearsonhighered.com/assets/bigcovers/0/1/3/4/0134576977.jpg', 'Learning Angular teaches modern application development with Angular 2 and Angular 4. It begins with the basics of Angular and the technologies and techniques used throughout the book, such as key features of TypeScript, newer ES6 syntax and concepts, and details about the tools needed to write professional Angular applications.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (2, 1, 'React Explained', 'https://www.ostraining.com/cdn/images/books-club/react.jpg', 'Why has React become so popular? It exists in an ever expanding, ever changing field of JavaScript libraries and frameworks. However, as it stands today, React seems to be the go-to choice for doing what it does. Reacts popularity can be boiled down to simplicity, ingenuity, and being at the right place at the right time. In React Explained, readers will dig deep into how React works and will learn how to build applications with it. While the focus is on building for the frontend on the web, many of the skills you will learn will also apply to writing React on the server side, for native applications and even for Virtual Reality environments.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (3, 3, 'Core Java SE 9', 'https://horstmann.com/javaimpatient/cover2.jpg', 'Readers familiar with Horstmanns  original, two-volume “Core Java” books who are looking for a comprehensive, but condensed guide to all of the new features and functions of Java SE 9 will learn how these new features impact the language and core libraries. Instead of the meticulous detail that the much larger two-volume set provides, this condensed treatment focuses on practical examples and is presented in bite-sized chunks.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (4, 3, 'Java A Beginners Guide', 'https://cdn11.bigcommerce.com/s-igquupw3/images/stencil/500x500/products/917463/28780225/9781260440218__03679.1616541936.jpg?c=2', 'Fully updated for Java Platform, Standard Edition 11 (Java SE 11), Java: A Beginners Guide, Eighth Edition gets you started programming in Java right away. Best-selling programming author Herb Schildt begins with the basics, such as how to create, compile, and run a Java program.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (5, 6, 'Javascript Everywhere', 'https://learning.oreilly.com/library/cover/9781492046974/250w/', 'JavaScript is the little scripting language that could. Once used chiefly to add interactivity to web browser windows, JavaScript is now a primary building block of powerful and robust applications. In this practical book, new and experienced JavaScript developers will learn how to use this language to create APIs as well as web, mobile, and desktop applications.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (6, 6, 'Full Stack Serverless', 'https://learning.oreilly.com/library/cover/9781492059882/250w/', 'Cloud computing is typically associated with backend development and DevOps. But with the rise of serverless technologies and a new generation of services and frameworks, frontend and mobile developers can build robust applications with production-ready features such as authentication and authorization, API gateways, chatbots, augmented reality scenes, and more. This hands-on guide shows you how.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (7, 1, 'Full Stack React Native', 'https://images-na.ssl-images-amazon.com/images/I/51071Pm5H7L._SX404_BO1,204,203,200_.jpg', 'Building the same app in both Swift and Java is time-consuming. With React Native, you can release a native app on both iOS and Android from a single codebase.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (8, 1, 'Pro React 16', 'https://media.springernature.com/w153/springer-static/cover/book/9781484244517.jpg', 'Use the enormously popular React framework to build dynamic JavaScript applications that take advantage of the capabilities of modern browsers and devices. You will learn how React brings the power of strong architecture and responsive data to the client, providing the foundation for complex and rich user interfaces.');
insert into book (author_id, genre_id, title, cover_url, synopsis) values (9, 7, 'Web Development w Node and Express', 'https://learning.oreilly.com/library/cover/9781492053507/250w/', 'Build dynamic web applications with Express, a key component of the Node/JavaScript development stack. In this updated edition, author Ethan Brown teaches you Express fundamentals by walking you through the development of an example application. This hands-on guide covers everything from server-side rendering to API development suitable for usein single-page apps (SPAs).');

commit;