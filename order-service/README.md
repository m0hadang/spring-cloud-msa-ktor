# Check
- 주문 조회 : http://localhost:8000/order-service/1/orders
- 주문 추가 : POST http://localhost:8000/order-service/1/order
```json
{
    "productId": "CATALOG-001",
    "qty" : 10,
    "unitPrice" : 1500
}
```