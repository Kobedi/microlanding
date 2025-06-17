# microlanding
An app to simulate the financial loan transaction and record keeping. I have attempted to follow the Domain Driven Design (DDD) and API first approach. The only portion I have is tied to event processing, specifically the loan module (package) updating the initial payment application via the CustomerLoanApplication entity. The various subsequent installments will be recorded in the payment history table until the loan is fully settled. The following picture seeks to show all modules planned. 

<img width="906" alt="image" src="https://github.com/user-attachments/assets/8d0f24ed-04a0-4d30-b443-daa1396599d8" />

Database Initialization

At app initialization, I have also included a mechanism to pre-load the database with a set of defined loans, along with their respective catalogue listing and applicable installments. These will be automatically written to the LOAN table under the TEST schema. 
<img width="596" alt="image" src="https://github.com/user-attachments/assets/e5b0ffe4-6036-420c-afbf-602d8eb6c4e5" />


