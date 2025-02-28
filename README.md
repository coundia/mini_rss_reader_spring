# Full-Stack Monorepo: Angular & Spring Boot

This project is a **full-stack monorepo** using **Angular** for the frontend and **Spring Boot** for the backend.

## Project Structure
```
/my-monorepo
  ├── /backend        # API Spring Boot 2
  ├── /frontend       # Angular 13 Application
  ├── /docs           # Documentation (optional)
  ├── Taskfile.yml    # Task automation
  ├── README.md       # Project documentation
```

---

## Prerequisites
Make sure you have installed:
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
This command installs dependencies for both backend and frontend.

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

### Start Both Backend and Frontend:
```sh
task start
```

---

## Building the Project

### Build Frontend:
```sh
task build:frontend
```

### Build Backend:
```sh
task build:backend
```

### Build and Deploy the Full Application:
```sh
task deploy
```
The frontend build will be copied into the backend to be served as static files.

---

## Cleaning the Project
```sh
task clean
```
This command removes build files and cleans the Maven repository.

---

## Deployment
After building, the frontend is copied to `backend/src/main/resources/static/`, allowing Spring Boot to serve the Angular application.
```sh
task deploy
```

---

## Common Issues

### NPM Dependency Errors
If you face dependency errors with npm, try:
```sh
rm -rf node_modules package-lock.json
npm install --legacy-peer-deps
```

### OpenSSL Issue with Node.js
If using a recent Node.js version, set this environment variable:
```sh
export NODE_OPTIONS=--openssl-legacy-provider
```

---

## Author
**Coundia** - Full-Stack Developer

---

## License
MINI PROJET FLUX RSS PROGRAMME SOFTWARE ENGINEERING EDACY - DIGITAL AFRICA - flux rss - le monde

