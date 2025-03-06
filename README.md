# Observability Demo

This repository demonstrates observability using Prometheus and Grafana with a sample Spring Boot application. The setup is configured to run locally using Docker Compose.

## Features
- **Prometheus** for metrics collection
- **Grafana** for visualization
- **Spring Boot Application** exposing metrics via `/actuator/prometheus`
- **Pre-configured Dashboard** (Standard Spring Boot dashboard)

## Prerequisites
- Docker
- Docker Compose
- Java 17+

## Setup Instructions

1. Clone the repository:
   ```sh
   git clone https://github.com/kkadoshnikov/spring-observability-demo.git
   cd observability-demo
   ```

2. Start Prometheus and Grafana using Docker Compose:
   ```sh
   docker-compose up -d
   ```

3. Start the Spring Boot application:
   ```sh
   ./gradlew bootRun
   ```

4. Access Grafana at [http://localhost:3000](http://localhost:3000)
    - Default login: `admin` / `admin`
    - Navigate to **Dashboards** → **Manage** → **Spring Boot Dashboard**

## Prometheus Configuration
The Prometheus configuration (`prometheus.yml`) is set up for macOS:
```yaml
scrape_configs:
  - job_name: 'demo-app'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8080']
```

## Stopping Services
To stop and remove the containers, run:
```sh
docker-compose down
```

## Notes
- Ensure the Spring Boot application is running before accessing Grafana.
- Modify the `prometheus.yml` configuration if running on a different OS.

## License
This project is free to use by anyone.

