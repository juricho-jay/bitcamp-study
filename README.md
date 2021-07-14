# bitcamp-study

## Day 1
- You need to set git info first >> **git config** (Only once)
- git config --global user.email "your email"
- git config --global user.name "your ID"

- After setting the "git config", upload your file!
- git add . (. contains all your files that you've changed, added, or deleted)
- git commit -m "detailed backup note"
- git push (enter username and token)

- Software    
    - System S/W, Application S/W
    - Standalone, Client/Server, Web Application
    - Web application component: Java App, HTML/CSS/JavaScript
    JavaScript
    - Back-end: Technology description of Java Application
    - Front-end: Techonology description of HTML/CSS/JavaScript
- Programming tools
    - Installing WebEx: online meeting program
    - Creating a personal account in github.com
    - Creating a personal repository in github.com
    - Importing/downloading files from an instructor's repo.
    - Importing added files to your repo.


## Day 2
- Programming tools (cont.)
    - Using github
        - Copy/clone a git server repo. to your local
        - Back up your files to the local repo.
        - Upload/push the local content to a server repo.
        - Import change of server repo. to local repo.
    - Installing VSCode editor
    - Installing mingw64 window gcc compiler
    - Installing JavaScript interpreter; node.js
- Creating and running programs  
    - **compile**
        - Creating a program that outputs "Hello, world!" with C language        
        - Relationship between source and machine language; source and compile; source and compiler
        - What is machine language? 
            - CPU instruction set: Code that a CPU can understand
            - Relationship between machine language and CPU
            - Relationship between machine language and OS
    - **Interpreter**
        - Creating a program that outputs "Hello, world!" with JavaScript language

OTHERS
- JCK (JRE + Development kit) > JRE (JVM + Library files) > JVM (Java Virtual Machine)
- bytecode: virtual machine language run by JVM
- Command Line Interface (CLI) ex: console, cmd-0
- VSCode edits source files
- Emulator (ex:Rosetta 2): Convert/emulate CPU instructions to a certain instruction


## Day3
- Programming tools (cont.)
    - Installing Java 11 JDK
        - Setting the JAVA_HOME environment variable
        - Setting the PATH environment variable
- Creating and running programs (cont.)
    - Comparing compile process and interpretation process
        - Programming language, compile, and compiler
    - Introduction to Java programming
        - Compiling and running Java
- Creating proeject folder of Java application
    - Relationship between application and project
    - Managing your projects in github
        - Step 1: Do not categorize source files and .class files.
        - Step 2: Divide src files and .class files by using a src folder and bin folder
        - Step 3: Standard directory structure of Maven project
        - Step 4: Creating multiple projects in git repo.

## Day 4
- Programming tools (cont.)
    - Installing Gradle
        - Setting the PATH variable environment
- Managing projects
    - Application and projects
    - Root projects and sub projects
    - Projects and tasks
    - Directory structure for storing project products
    - Team projects and git repo.
    - Various types of managing projects with git repo.
- Curriculum
    - Studying theories and practicing project examples
    - Roadmap of practice (study-project)
- Build tools
    - Introduction to build tools
    - Various build tools: Ant, maven, and Gradle
    - Preparing project folders using Gradle build tool
        - 'gradle init'
    - Directory structure created by Gradle build tool and file descriptions
- Gradle build tool guide
    - Use of build script files
        - settings.gradle: common setting information applied to various projects
        - app/buil.gradle: build setting information only applied to sub projects
    - 'java' gradle plugins
        - compileJava
            - Compiling all source files in a src/main/java folder
            - Storing .class files in the build/classes/java/main folder
        - compileTestJava
            - Compiling all source files in a src/test/java folder
            - Storing .class files in a build/classes/java/test folder
        - processResources
            - Copying files in a src/main/resources folder into a build/resources/main folder
        - processTestResources
            - Copying files in a src/test/resources folder into a build/resources/test folder
        - clean
            - Deletes build folders
        - classes
            - Executes compileJava and processResources
        - testClasses
            - Executes classes + compileTes.java + processTestResources
        - check 
            - Executes test + unit test
        - javadoc
            - Creates API documents generating javadoc documentation from source files in HTML format
        - build
            - Executes check + assemble (creating distribution files)
    - 'application' gradle plugins
        - run
            - Execute a classes task of 'java' plugins
            - Then execute a certain class specified in the application setting
            - If you exetcute a build task with this plugin installed, files that can be distributed to customers are created in a build/distributions folder.
            - Also, a script file that can run the Java program is created automatically.
    - Summary
        - 1. Prepare a project foler by executing an init task.
        - 2. Set up the plugin in build script that contains a build task.
        - 3. Set up information that are needed when executing each plugin task.
        - 4. Set up referenced library files you want use in your projects.
        - 5. Build the application by executing tasks you needed.

## Day 5
- Programming tools (Cont.)
    - Downloading and installing the development tool
    - Eclipse IDE preferences
        - Refer to the eomcs-docs/devtool/개발도구준비.md file
- Git
    - Creating a local repo.
        - 'git init'
    - Creating a server repo.
        - Click the new button in 'github.com'
    - Registering a server repo. route in the local repo.
        - 'git remote origin server repo. URL'
    - Uploading/pushing content of the local repo. into the server
        - 'git push'
- Java basic syntax (eomcs-java)
    - ex01
        - Managing a package
        - Java source files and blocks (class)
        - Encoding of source files
        - main() method
    - ex02
        - Multi-line comments and single-line comments
        - javadoc comments
        - annotations
- Practice projects (eomcs-java-project-2021)
    - 01-b: Preparing projects : Import into 'Eclipse IDE

0714 exam 0310!



    
