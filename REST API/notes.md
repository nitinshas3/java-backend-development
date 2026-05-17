# REST API Notes

## Core Idea
- REST = **Representational State Transfer**
- Client interacts with **resources** via endpoints (URLs).
- Each resource has a **state** (the current value of the object ).
- Communication happens over **HTTP** using methods: GET, POST, PUT, DELETE.
- Responses usually in **JSON**.

---

## State of an Object
- Resource = object (e.g., User). basically the processed data , we are accessing it instead of direct function calls which happened in rmc or soap ;
- **State** = current values of its attributes.
- REST transfers this **representation of state** (JSON), not the actual object.




Before REST
SOAP → Heavy XML, strict contracts (like filling forms).

RPC → Direct function calls (getUser(123)), tightly coupled.

Custom Protocols → Proprietary formats, fast but not standard/

## Jersey vs Servlet

### 🔎 Servlet
- Low-level Java API for handling HTTP requests/responses.
- Extend `HttpServlet` and override `doGet()` / `doPost()` methods.
- Work directly with `HttpServletRequest` and `HttpServletResponse`.
- Lifecycle: `init()` → `service()` → `destroy()`.
- High boilerplate: manual parsing of parameters, headers, status codes, and output.
- Best for learning fundamentals or when fine-grained control is needed.

### 🌐 Jersey (JAX-RS Implementation)
- Framework built on top of Servlet API.
- Implements JAX-RS spec (Java EE standard for RESTful APIs).
- Uses annotations (`@Path`, `@GET`, `@POST`, `@Produces`, `@Consumes`) for declarative routing.
- Automatically handles request parsing, content negotiation (JSON/XML), and response formatting.
- Lower boilerplate: focus on business logic instead of HTTP plumbing.
- Best for building REST APIs quickly and in a standardized way.

### ⚖️ Key Difference
- **Servlet** = raw HTTP handling (manual, imperative).
- **Jersey** = REST framework built on Servlet (declarative, standardized).
- Jersey internally registers a `ServletContainer` to delegate requests, so Servlet knowledge is still the foundation.

## 🧩 What a Servlet Does
- Receives raw HTTP request from the browser via the servlet container (Tomcat/Jetty).

### Request object (`HttpServletRequest`)
Gives you access to:
- Query parameters → `req.getParameter("id")`
- Headers → `req.getHeader("User-Agent")`
- Cookies → `req.getCookies()`
- Body (for POST requests) → `req.getInputStream()` or `req.getReader()`

### Response object (`HttpServletResponse`)
You set:
- Status code → `resp.setStatus(200)`
- Headers → `resp.setHeader("Content-Type", "application/json")`
- Body → `resp.getWriter().println("Hello")`

👉 So yes, you manually parse headers, parameters, body and then manually set status codes, headers, and response content.

---

## 🌐 Why Jersey is Different
Jersey wraps all that manual work:
- Instead of `doGet/doPost`, you just annotate methods with `@GET`, `@POST`.
- Instead of manually parsing JSON, Jersey auto‑converts request bodies into Java objects.
- Instead of manually writing response text, Jersey auto‑serializes your return value into JSON/XML/HTML.


- majorly in modern times springboot mvc is used instead of jersey , jersey is used in - legacy systems , both the springboot mvc and jersey are built on servlet 
- 📊 Analogy
 - Servlet = waiter who takes orders and cooks food himself.

- DispatcherServlet = head waiter who just takes the order and sends it to the right chef (controller).

- You (developer) only write the chef’s recipe (controller logic), not the plumbing.







# 🚦 DispatcherServlet in Spring Boot

## 🔎 What is DispatcherServlet?
- A **front controller servlet** in Spring MVC.
- Every HTTP request first passes through it.
- It decides which controller method should handle the request.
- Converts raw `HttpServletRequest` / `HttpServletResponse` into Java objects and back.

---

## ⚙️ Workflow
1. **Request Entry**
    - Browser sends request → Embedded Tomcat/Jetty receives it.
2. **DispatcherServlet**
    - Registered automatically by Spring Boot.
    - Acts as the traffic cop for all requests.
3. **Handler Mapping**
    - Finds the correct controller method (`@GetMapping`, `@PostMapping`, etc.).
4. **Controller Execution**
    - Runs your business logic method.
    - Injects parameters (`@PathVariable`, `@RequestParam`, `@RequestBody`).
5. **Response Handling**
    - Converts return values into HTTP response (JSON/XML/Text).
    - Sends back to browser.

---


---

## ✅ Takeaway
- **Spring Boot** → provides ecosystem + auto‑config + embedded server.
- **DispatcherServlet** → core router, handles request/response plumbing.
- **You** → focus only on writing business logic in controller methods.




- so like in servlet you respond with html thing , but in rest you respond with json format or xml format , but still when jersey project is built in maven it gives index.jsp , thats just to test nothing else we dont use it to respond


