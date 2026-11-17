# Skill Experiment 5: Securing APIs with CORS

This project demonstrates a Spring Boot REST API (`/profile`) and a separate frontend running on another origin.

## Requirements
- Java 17+
- Maven 3.8+
- A browser

## Run the backend
Open a terminal in `backend` and run:

```bash
mvn spring-boot:run
```

Backend URL: http://localhost:8080  
API endpoint: http://localhost:8080/profile

## Run the frontend
Open `frontend/index.html` in a browser, or (recommended) serve it on a separate origin:

```bash
cd frontend
python -m http.server 5500
```

Open http://localhost:5500.

Click **Fetch Profile**. With the supplied CORS configuration, the browser should display the profile JSON.

## Step 2: Test without CORS
1. Open `backend/src/main/java/com/example/cors/config/CorsConfig.java`.
2. Temporarily comment out the `@Configuration` annotation and the `CorsFilter` bean (or remove the file).
3. Restart the backend.
4. Reload the frontend and click **Fetch Profile**.

The browser console should show a CORS error because the backend does not send the required `Access-Control-Allow-Origin` response header.

Restore the configuration and restart the backend to continue.

## Step 3: Enable CORS
The supplied `CorsConfig.java` allows:
- Origin: `http://localhost:5500`
- Methods: `GET`, `POST`, `PUT`, `DELETE`, `OPTIONS`
- Headers: all request headers
- Credentials: disabled

Change the allowed origin if you serve the frontend from a different address.

## Expected result
- Without CORS: browser blocks frontend JavaScript from reading the cross-origin response.
- With CORS: browser permits the frontend JavaScript to read the response.

Note: CORS is enforced by browsers. It is not authentication or authorization, and it does not stop direct requests from tools such as curl or Postman. Keep the allowed origins and methods as restrictive as your application requires.
