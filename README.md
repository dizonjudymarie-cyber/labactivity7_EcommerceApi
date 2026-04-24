# Ecommerce API - Spring Boot

## Project Overview
RESTful API for managing products using Spring Boot with in-memory storage.

---

## How to Run
1. Open project in IntelliJ
2. Run `EcommerceApiApplication`
3. Server runs at:
   http://localhost:8080

---

## API ENDPOINTS

### GET ALL
GET /api/v1/products

### GET BY ID
GET /api/v1/products/{id}

### CREATE
POST /api/v1/products

### UPDATE
PUT /api/v1/products/{id}

### DELETE
DELETE /api/v1/products/{id}

### FILTER
GET /api/v1/products/filter?filterType=name&filterValue=phone

---

## Status Codes
- 200 OK
- 201 Created
- 204 No Content
- 404 Not Found
- 500 Internal Server Error

---

## Notes
- Uses in-memory List<Product>
- No database required
- Data resets when app restarts