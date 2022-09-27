# ModernREST

Minimal JakartaEE 9 / Jersey 3 / Jetty 11 REST webapp with sessions and static files.

## Build and run the Web Server

```shell
mvn clean package
java -jar target/ModernREST.jar src/main/resources
```

### Web Server Running Configuration

- You can use these extra configuration options when running the web server to allow to bind to different ports in your system.
- **Example:**
  - `java -Dport=8032 -Dhost=0.0.0.0 -jar target/ModernREST.jar src/main/resources`
  - This will run the project on port `8032` and accessible from within your network using `0.0.0.0`.

| Option   | Description                                          | Default   |
|----------|------------------------------------------------------|-----------|
| **port** | The port number to run the web server of.            | 8080      |
| **host** | The hostname to be used when running the web server. | 127.0.0.1 |
