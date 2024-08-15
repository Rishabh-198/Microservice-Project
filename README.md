# Microservice Project

This project demonstrates a microservices architecture by dividing a large application into smaller, independent codebases that interact via APIs. Unlike monolithic architectures, microservices promote scalability and maintainability by using various components and patterns to manage services effectively.

For more information, you can refer to the following article: [Microservices Architecture](https://laser-asphalt-42f.notion.site/MICROSERVICES-c6334c158d81411fa7a7342eedff1797)


## Key Components

- **Service Registry:** Manages service information and supports dynamic service registration and discovery.
- **API Gateway:** Routes requests to appropriate microservices, providing a single entry point for clients.
- **Microservices:** Includes various services such as User, Hotel, and Rating, each handling specific functionalities.

## Technology Stack

- **Programming Language:** Java
- **Frameworks:** Spring Boot
- **Service Discovery:** Eureka
- **Inter-Service Communication:** RestTemplate, Feign Client
- **Configuration Management:** Config Server
- **Fault Tolerance:** Resilience4j (Circuit Breaker, Retry, Rate Limiter)
- **Databases:** MYSQL, PostgreSQL, MongoDb

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/microservice-project.git

2. **Navigate to the Project Directory:**

     ```bash
     cd microservice-project
3. **Run the services**
   
     API Gateway: Accessible at http://localhost:8080
   
     Service Registry: Accessible at http://localhost:8761

     Configuration Management: Centralized configuration can be managed via the Config Server.

## Features

- **Dynamic Service Registration and Discovery** with Eureka
- **Unified Entry Point** for clients using the API Gateway
- **Flexible Inter-Service Communication** via RestTemplate and Feign Client
- **Centralized Configuration Management** using Config Server
- **Enhanced Fault Tolerance** with Resilience4j

## Contributing

Contributions are welcome! Please submit issues, feature requests, or pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

