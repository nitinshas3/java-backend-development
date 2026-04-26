# Fundamentals of Client-Server Architecture

## 🔑 Key Idea
Client-Server architecture is a model where **clients** request services and **servers** provide them. It is the backbone of web applications and modern networking.

---

## 🖥️ Client System
- The **client** is typically a user’s device (PC, laptop, mobile).
- It runs applications like **web browsers**.
- The client initiates communication by sending **HTTP requests** to the server.

---

## 🗄️ Server System
- The **server** hosts resources such as web applications, databases, or files.
- It listens on a specific **IP address** and **port number**.
- When a client sends a request, the server processes it and returns the appropriate response (HTML, JSON, files, etc.).

---

## 🌐 Communication Flow
1. The client enters a **URL** in the browser.
2. The browser sends an **HTTP request** to the server.
3. The request includes the **IP address** and **port number** of the server.
4. The server processes the request and sends back the **response**.
5. The browser displays the response to the user.

---

## 📌 Role of DNS
- **DNS (Domain Name System)** translates human-readable domain names (e.g., `www.example.com`) into machine-readable **IP addresses**.
- This means users don’t need to remember raw IP addresses.
- Example: `www.google.com` → DNS resolves to `142.250.190.14`.

-------------------

servlet is a java program residing in server side machine to accept http request and generate dynamic results to send it back , it is not executed by jvm ,so it does not require the main function , it will be executed by server side software 

we also need to download server software in our machines, within that there will be a server container  to execute servlet

we will be using apache tomcat here as server software 

---------------------

# 📝 Setting up Java Web App (Servlet + JSP) using IntelliJ + Tomcat

---

# 🔹 PART 1: ONE-TIME SETUP (Do only once)

## 1. Install Requirements

* Install JDK (prefer Java 17)
* Install Apache Tomcat (extract zip, e.g. `C:\apache-tomcat-10`)

---

## 2. Configure Tomcat in IntelliJ

* Open IntelliJ IDEA
* Go to: `Run → Edit Configurations`
* Click ➕ → **Smart Tomcat**

Fill details:

* **Name:** MyApp-Tomcat
* **Tomcat Server:** Select Tomcat folder (`C:\apache-tomcat-10`)
* **Port:** 8080
* **JRE:** Java 17
* **Classpath Module:** your project

👉 This setup is saved and reused

---

# 🔹 PART 2: CREATING A NEW PROJECT (Every time)

## 1. Create Project

* File → New Project
* Select **Maven**
* Choose archetype:

  ```
  maven-archetype-webapp
  ```
* Version:

  ```
  1.4
  ```

Fill:

* GroupId → `com.example`
* ArtifactId → `myapp`

---

## 2. Project Structure

Ensure this exists:

```
src/main/webapp/
 ├── index.jsp
 └── WEB-INF/
      └── web.xml
```

---

## 3. Add Required Dependency (Servlet API)

In `pom.xml`:

```xml
<dependency>
  <groupId>jakarta.servlet</groupId>
  <artifactId>jakarta.servlet-api</artifactId>
  <version>5.0.0</version>
  <scope>provided</scope>
</dependency>
```

---

## 4. Create Servlet

Location:

```
src/main/java/
```

Example:

```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().println("Hello World");
    }
}
```

---

## 5. Configure Smart Tomcat (for project)

* Go to `Edit Configurations`
* Duplicate existing config OR create new

Set:

* **Deployment Directory:**

  ```
  src/main/webapp
  ```
* **Context Path:**

  ```
  /myapp
  ```

---

## 6. Run Project

* Click ▶️ Run
* Open browser:

```
http://localhost:8080/myapp
```

Servlet:

```
http://localhost:8080/myapp/hello
```

---

# 🔹 PART 3: WORKFLOW (Daily Use)

For new projects:

1. Create project
2. Copy/duplicate Tomcat config
3. Run ▶️
4. Refresh browser

---

# 🔹 IMPORTANT NOTES

* Do NOT use `mvn exec:java` for web apps
* Web apps run on Tomcat (browser)
* `pom.xml` should be edited carefully (don’t blindly delete everything)
* Tomcat setup is done only once

---

# 🔹 SIMPLE FLOW

```
Write Code → Run Tomcat → Open Browser
```

---

# 🔹 KEY CONCEPT

* IntelliJ = Development
* Maven = Build tool
* Tomcat = Server (runs app)
* Browser = Output

--------------------

file structure 

MyWebApp/
├── src/
│   ├── main/
│   │   ├── java/                # All Java code (Servlets, helpers)
│   │   │    └── com.example.web/
│   │   │         └── LoginServlet.java
│   │   └── webapp/              # All web files
│   │        ├── index.jsp       # Homepage JSP
│   │        ├── login.jsp       # Login form JSP
│   │        ├── welcome.jsp     # After login JSP
│   │        ├── WEB-INF/
│   │        │    ├── web.xml    # Servlet mappings (if not using annotations)
│   │        │    └── lib/       # Extra JARs if needed
│   │        └── static/         # CSS, JS, images
├── pom.xml                      # Maven build file (dependencies)





