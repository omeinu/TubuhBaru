# TubuhBaru

TubuhBaru is a monorepo health management application using Vue 3 and Spring Boot.

## Structure

- `frontend/` - Vue 3 project powered by Vite.
- `backend/` - Spring Boot (Java 17) backend API.

## Data Flow

```mermaid
flowchart TD
    subgraph Frontend
        MI[MealInput] -->|POST /api/meals| API
        WI[WeightInput] -->|POST /api/weights| API
        ML[MealList] -->|GET /api/meals| API
        WC[WeightChart] -->|GET /api/weights| API
    end

    subgraph Backend
        API --> MC[MealRecordController]
        API --> WCtl[WeightRecordController]
        MC --> MS[MealRecordService]
        WCtl --> WS[WeightRecordService]
        MS --> GPT[ChatGptService]
        MS --> MR[(MealRecordRepository)]
        WS --> WR[(WeightRecordRepository)]
    end
```

## Data Model

```mermaid
classDiagram
    class MealRecord {
        long id
        String menuText
        String aiComment
        LocalDateTime createdAt
    }
    class WeightRecord {
        long id
        double weight
        LocalDateTime recordedAt
    }
```

## Development

### Backend

```bash
cd backend
mvn spring-boot:run
```

The backend exposes:

- `GET /api/hello` – simple hello API returning a JSON message.
- `POST /api/meals` – accepts a JSON body with `menuText`.
- `POST /api/weights` – accepts `weight` and `recordedAt` as JSON.

### Frontend

```bash
cd frontend
npm install # install dependencies
npm run dev
```

The frontend includes a `MealInput` component that posts to `/api/meals`.
It also provides a `WeightInput` component for sending weights to `/api/weights`.

### Running Tests

Backend tests can be run with Maven:

```bash
cd backend
mvn test
```
