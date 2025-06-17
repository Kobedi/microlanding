# microlanding
An app to simulate the financial loan transaction and record keeping. I have attempted to follow the Domain Driven Design (DDD) and API first approach. The only portion I have is tied to event processing, specifically the loan module (package) updating the initial payment application via the CustomerLoanApplication entity. The various subsequent installments will be recorded in the payment history table until the loan is fully settled. The following picture seeks to show all modules planned. 

<img width="906" alt="image" src="https://github.com/user-attachments/assets/8d0f24ed-04a0-4d30-b443-daa1396599d8" />


Database Initialization

At app initialization, I have also included a mechanism to pre-load the database with a set of defined loans, along with their respective catalogue listing and applicable installments. These will be automatically written to the LOAN table under the TEST schema. 

<img width="596" alt="image" src="https://github.com/user-attachments/assets/e5b0ffe4-6036-420c-afbf-602d8eb6c4e5" />

I have also attempted to associate every loan application to a customer, hence created a customer table, linking it to a loan application. I have exposed these as shown below. The real value is the creation of the actual loan application. See two images below.  

<img width="1315" alt="image" src="https://github.com/user-attachments/assets/66259ddf-ed7b-48c9-925f-e162e8530ec3" />


<img width="1165" alt="image" src="https://github.com/user-attachments/assets/71d9ab57-581e-4e2f-80a1-8bcc20231878" />


