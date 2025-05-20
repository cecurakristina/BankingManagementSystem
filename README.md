# Banking Management System - RESTful Web Service

**Author:** Kristina Cecura  
**Student ID:** 2495184

## Project Overview

This project implements a **Banking Management System** using **Jakarta RESTful Web Services** in a **Maven Dynamic Web Project**. It allows banking staff to retrieve and search customer and account data using various REST endpoints. Responses are available in both **HTML** and **JSON** formats.

---

## Business Impact

The implementation of RESTful Web Services in this system brings significant benefits:

- **Improved Accessibility:** Bank staff can access account and customer data quickly and easily.
- **Extensibility:** New features (e.g., `POST`, `DELETE`) can be added without changing existing endpoints.
- **Efficiency:** Advanced search features (e.g., by balance, name, account type) reduce manual processing and improve customer satisfaction.

---

## Design Architecture

The system uses Jakarta REST annotations to implement its RESTful structure:

- `@Path` — Defines the base URL path for a resource.
  - Example: `@Path("/WebCustomer")` maps all customer-related routes.
- `@GET` — Indicates that a method handles HTTP GET requests.
- `@Produces` — Specifies the return media type:
  - `MediaType.TEXT_HTML` — Returns HTML data.
  - `MediaType.APPLICATION_JSON` — Returns JSON data.
- `@QueryParam` — Extracts query parameters from the URL.
  - Example: `/WebCustomer/search?name=John`

### Resource Classes

- **WebCustomerResource** — Handles customer-related endpoints (listing, searching by name).
- **WebAccountResource** — Handles account-related endpoints (listing, searching by type, balance, and customer ID).

---

## Data Structure Used

- The project uses **`ArrayList`** to store customer and account data in memory.
- These lists are stored in a **singleton `BankData` class**:
  ```java
  ArrayList<Customer> customerList;
  ArrayList<Account> accountList;
