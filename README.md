# ontop
ontop Spring Boot 
prerequisities :
JDK 1.8+
Spring Boot 2.6


Mai  Controller :
-Beneficiary Controller API ("api/v1/beneficiarys")
-WalletPaymentController API ("/api/v1/payments")
-WalletTransactionController API ("wallets")

 to build & run:
 -mvn clean install
 -mvn spring-boot:run 
 
 first step should  create beneficiary :
 ex :
 http://localhost:8080/api/v1/beneficiarys/beneficiary
 
 Input sample :
 
{
  "firstName": "Bashar",
  "lastName": "Othman",
  "routingNumber": 110110,
  "nationalIdentificationNumber": "9874562221",
  "accountNumber": "120120",
  "amount": 1000
}
