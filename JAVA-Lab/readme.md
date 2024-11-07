# Steps for JDBC Connection

This guide provides detailed instructions on setting up a JDBC connection in Visual Studio Code (VS Code) using the "Project Manager for Java" extension.

## Prerequisites
- Visual Studio Code (VS Code) installed
- XAMPP installed
- JDBC driver `.jar` file (e.g., `mysql-connector-java.jar`)

## Steps for JDBC Connection

1. **Install Project Manager for Java**
   - Install the **Project Manager for Java** extension in VS Code to manage Java projects easily.
   - Go to the Extensions view in VS Code (`Ctrl+Shift+X`), search for "Project Manager for Java," and install it.

2. **Add the JDBC `.jar` File**
   - Open your Java project in VS Code (Open the folder in which the JDBC files are present).
   - Go to the **Java Projects** tab in the Explorer panel.
   - Under the **Referenced Libraries** section, click the **'+'** sign.
   - Add the `.jar` file (e.g., `mysql-connector-java.jar`) as a referenced library for JDBC functionality.

3. **Start Apache and MySQL Servers**
   - Open the **XAMPP Control Panel**.
   - Start the **Apache Server** and **MySQL** services.

4. **Run the Java File**
   - Run your Java program using the **Run Java** button in VS Code.
   - **Important:** Do **not** use the **Code Runner** (Run Code button) to avoid issues related to dependency handling.
