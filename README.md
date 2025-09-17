# Kafka Timeline Project

This is a **full-stack sample project** demonstrating a live timeline chart using **Kafka**, **Spring Boot**, and **React**.  
The backend produces and consumes data from Kafka, while the React frontend displays the data in a live-updating chart.

---

## **Features**

- Spring Boot backend:
  - Produces random timeline data every second (`ScheduledDataProducer`)
  - Consumes messages from Kafka and stores them in memory (`DataConsumer`)
  - REST endpoint `/api/data` returns consumed messages
- React frontend:
  - Displays data in a live timeline chart (`recharts`)

---

## **Requirements**

- Docker & Docker Compose
- Java 11+
- Maven (for backend)
- Node.js + npm (for frontend)

---

## **Docker Setup**

The project uses **Kafka and Zookeeper in Docker**, while backend and frontend can run either in Docker or locally.


1. **Build and start all services:**
    ```sh
    docker-compose up --build
    ```

2. **Access the services:**
    - Frontend: [http://localhost:3000/](http://localhost:3000/)
![alt text](https://github.com/jmendes477/kafka-timeline-project/blob/main/img/example.png?raw=true)

3. **Stopping services:**
    ```sh
    docker-compose down
    ```