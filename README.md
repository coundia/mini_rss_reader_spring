# MINI RSS FEED PROJECT

## Project Context

**Mini RSS Feed Project**

PROGRAM: SOFTWARE ENGINEERING - EDACY - DIGITAL AFRICA

### Objective

The goal of this project is to develop an RSS feed reader.

### Functional Requirements

- Retrieve the RSS feed from *Le Monde* [https://www.lemonde.fr/rss/en_continu.xml](https://www.lemonde.fr/rss/en_continu.xml)
- Display the feed in a listing format with images and excerpts
- Implement pagination
- Allow users to edit the title
- Allow users to edit the excerpt

### Constraints

- **Frontend language**: Angular (mandatory)
- **Backend language**: Any (developer's choice)
- **Deadline**: 2 days, to be submitted by Thursday, April 21 at 12:00 PM GMT

### Deliverables

- GitHub repository of the project
- A **README** explaining the technologies used and how to run the application
- Bonus for those who can provide a link where the application can be tested (e.g., Heroku)

---

## Technologies Used

### **Modeling: [C4 Model](https://c4model.com/)**

The **C4 model** is a lightweight graphical notation technique for modeling software architecture. It is based on the structural decomposition of a system into containers and components.

### **C4 Model Terminologies**

#### **Person**
Represents different users of the system.

#### **System**
The highest level of abstraction in the C4 model, describing the functional requirements of users.

#### **Container**
Represents something that hosts code or data and must run for the system to function.

#### **Component**
A grouping of related functionalities encapsulated behind a well-defined interface.

#### **Code**
Represents the **Conceptual Data Model (CDM)**.

### **Model Representation**

#### **Context Diagram**

![Context](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/context.png)

#### **Container (Architecture Diagram)**

![Architecture](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/container.png)

---

## Backend ([SPRING](https://spring.io/why-spring))

Spring is an open-source Java framework offering:
- Lightweight architecture
- Fast development
- Strong community support
- Comprehensive tools

### **Running the Backend**

#### **Option 1: Using the Release Binary**

1. Download the binary:
   ```bash
   wget https://github.com/coundia/mini_rss_reader_spring/releases/download/v1.1/mini_rss_reader_spring-v1.1.jar
   ```
2. Configure the Java Runtime Environment (JRE)
3. Run the application:
   ```bash
   java -jar mini_rss_reader_spring-v1.1.jar
   ```

#### **Option 2: Using Maven**

1. Clone the project:
   ```bash
   git clone https://github.com/coundia/mini_rss_reader_spring
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### **Backend API Endpoints**

- **Manage articles (GET, PATCH, POST, DELETE):** List, edit, etc.
  - [https://mini-rss-api.herokuapp.com/api/v1/rss/items](https://mini-rss-api.herokuapp.com/api/v1/rss/items)
- **Fetch articles from *Le Monde* and store in the database**
  - [https://mini-rss-api.herokuapp.com/api/v1/rss/refresh](https://mini-rss-api.herokuapp.com/api/v1/rss/refresh)
- **Check server status**
  - [https://mini-rss-api.herokuapp.com/api/v1/rss/status](https://mini-rss-api.herokuapp.com/api/v1/rss/status)

---

## Frontend (Angular)

### **Running the Frontend**

#### **Option 1: Using the Release Binary**

1. Download the distribution:
   ```bash
   wget https://github.com/coundia/mini-rss-reader/releases/download/v1.1/distV1.2.zip
   ```
2. Extract the zip file:
   ```bash
   unzip distV1.2.zip
   ```
3. If you do not have an Apache or Nginx server, install a simple HTTP server:
   ```bash
   npm install --global http-server
   ```
4. Run the application:
   ```bash
   cd distV1
   http-server -o
   ```

#### **Option 2: Using npm**

1. Clone the project:
   ```bash
   git clone https://github.com/coundia/mini-rss-reader
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run the application:
   ```bash
   ng serve
   ```

### **Test Link**

- **Frontend:**
  - [https://mini-rss-reader.herokuapp.com/](https://mini-rss-reader.herokuapp.com/)

---

## User Guide

### **Fetch Latest Articles from *Le Monde***

![Fetch Latest Articles](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/recuperer.png)

### **Article Listing**

![Article Listing](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/liste.png)

### **Edit Title or Description**

![Edit Title or Description](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/edit.png)

### **Result After Refreshing the Page**

![Result After Refresh](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/resultat.png)

### **Pagination**

![Pagination](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/img.png)

### **Progressive Web App (PWA) for Desktop and Mobile**

![PWA](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/img_1.png)

---

## Complete Documentation

[Full README](https://raw.githubusercontent.com/coundia/mini-rss-reader/main/README.md)

