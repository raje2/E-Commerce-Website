# E-commerce API with Spring Boot

This project is a set of RESTful APIs designed to support e-commerce operations using Spring Boot and JPA. It includes features such as product and category listing, cart management, order processing, user authentication, and more.

## Table of Contents
- [API Endpoints](#api-endpoints)
- [Database Integration](#database-integration)
- [Authentication Middleware and Security](#authentication-middleware-and-security)
- [Error Handling](#error-handling)
- [Documentation](#documentation)

## API Endpoints

1. **Category Listing:**
   - Endpoint: `/api/categories`
   - Description: Retrieve a list of categories.

2. **Product Listing:**
   - Endpoint: `/api/products?categoryId={categoryId}`
   - Description: Retrieve a list of products based on category ID.

3. **Product Details:**
   - Endpoint: `/api/products/{productId}`
   - Description: Get detailed information about a specific product by its ID.

4. **Cart Management:**
   - Endpoint: `/api/cartitems/add-to-cart/{productId}`
   - Description: Add a product to the user's cart.

   - Endpoint: `/api/cartitems/view-cart`
   - Description: View the user's cart.

   - Endpoint: `/api/cartitems/update-quantity/{cartItemId}?quantity={newQuantity}`
   - Description: Update the quantity of a product in the cart.

   - Endpoint: `/api/cartitems/remove-from-cart/{cartItemId}`
   - Description: Remove a product from the cart.

5. **Order Placement:**
   - Endpoint: `/api/orders/place-order`
   - Description: Place a new order with products from the user's cart.

6. **Order History:**
   - Endpoint: `/api/orders/order-history`
   - Description: View the order history for authenticated users.

7. **Order Details:**
   - Endpoint: `/api/orders/order-details/{orderId}`
   - Description: Fetch detailed information about a specific order by its ID.

8. **User Authentication:**
   - Endpoint: `/api/auth/register`
   - Description: Register a new user.

   - Endpoint: `/api/auth/token`
   - Description: Generate a JWT token for user authentication.

## Database Integration

The application uses Spring Data JPA to interact with a relational database for storing and managing product data, user cart information, and order details.

## Authentication Middleware and Security

Authentication and authorization are implemented using Spring Security and JSON Web Tokens (JWT). Sensitive endpoints require authentication for access.

## Error Handling

Robust error handling is implemented throughout the API, providing meaningful error messages and appropriate HTTP status codes.

## Documentation

API endpoints are documented using Swagger/OpenAPI. Access the documentation by running the application and visiting [http://localhost:8080/swagger-ui.html](http://localhost:8080).
