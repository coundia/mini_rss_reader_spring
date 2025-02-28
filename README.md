# Full-Stack Angular & Spring Boot Project
# mono repo

* README.md       
* Taskfile.yml    
* backend         => Api spring boot 2
* frontend        => angular 13
* backend.log     
* doc             


This project is a full-stack application using **Angular** for the frontend and **Spring Boot** for the backend.

## Prerequisites

Before getting started, make sure you have installed:
- **Java 17+**
- **Maven**
- **Node.js 16+** and **npm**
- **Angular CLI** (`npm install -g @angular/cli`)
- **Taskfile** (`go install github.com/go-task/task/v3/cmd/task@latest`)

---

## Project Setup

```sh
task setup
```
This command installs the backend and frontend dependencies.

---

## Running the Project

### Start Backend Only:
```sh
task start:backend
```

### Start Frontend Only:
```sh
task start:frontend
```

### Start Backend and Frontend Together:
```sh
task start
```

---

## Building the Project

### Build the Frontend:
```sh
task build:frontend
```

### Build the Backend:
```sh
task build:backend
```

### Build and Deploy the Full Application:
```sh
task deploy
```
The frontend build will be copied into the backend to be served statically.

---

## Cleaning the Project

```sh
task clean
```
This command removes build files and cleans the Maven repository.

---

## Deployment

After building, the frontend is copied into `backend/src/main/resources/static/`, allowing Spring Boot to serve the Angular application.

```sh
task deploy
```

---

## Common Issues

### npm Dependency Errors
If you encounter dependency errors with npm, try:
```sh
rm -rf node_modules package-lock.json
npm install --legacy-peer-deps
```

### OpenSSL Issue
If using a recent version of Node.js, set this environment variable:
```sh
export NODE_OPTIONS=--openssl-legacy-provider
```

---

## Author
**Coundia** - Full-Stack Developer

---

## License
This project is licensed under the MIT License.

