# Retailer Reward System

Retailer Reward System application provides a rewards program to the customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point

for every dollar spent between $50 and $100 in each transaction.

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

## Installation

1.Clone the repository i.e  
```bash
https://github.com/ravirazsahu/spring-boot-rewards-system.git
```
2. Navigate to the project directory 
```bash
cd spring-boot-rewards-system
```
3. Build the project using Maven command : 
```bash
mvn clean install
```
4. After successfully installing the project, you can run the project from STS.

5. The application will be available at 
```bash
http://localhost:9010/retailer-rewards
```
6. Please execute the insert queries available in the transaction_queries.sql file manually. For some reason, h2 db does not pick up this file while executing. I will fix that issue.


## API Endpoints
GET 
```bash
/api/reward
```
**Description:** Calculates and retrieves the reward points for each customer per month.

**Example:** To retrieve reward points, send a GET request to 
```bash
http://localhost:9010/retailer-rewards/api/reward/
```
**sample data:**
```bash
insert into transaction(customer_id,amount,date) values ('Roxy',120,'2024-04-18');
insert into transaction(customer_id,amount,date) values ('Roxy',80,'2024-05-10');
insert into transaction(customer_id,amount,date) values ('Jack',60,'2024-02-11');
insert into transaction(customer_id,amount,date) values ('Jack',150,'2024-02-18');
insert into transaction(customer_id,amount,date) values ('Sam',200,'2024-07-18');
```
**Response**
```bash
{
    "Roxy": {
        "MAY": 30,
        "APRIL": 90
    },
    "Jack": {
        "FEBRUARY": 160
    },
    "Sam": {
        "JULY": 250
    }
}
```

