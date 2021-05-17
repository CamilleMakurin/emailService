To send a payment order form do the following:

1.Start application
2.Open http://localhost:8080/swagger-ui.html
3.Make a POST request to payment order controller.
Smaple json:

{
  "sendTo": [
    "emailOne@gmail.com","emailTwo@gmail.com"
  ],
  "paymentOrder": {

    "customerNumber": "customerNumber",
    "date": "12 03 2021",
    "remitter": {
      "name": "remitterName",
      "personalIdNumber": "remitterId",
      "accountNumber": "remitterAccountNumber"
    },
    "beneficiary": {
      "companyName": "beneficiaryName",
      "registrationNumber": "beneficiaryId",
      "accountNumber": "beneficiaryAccountNumber",
      "bankCode": "beneficiaryBankCode",
      "beneficiaryBank": "beneficiaryBank",
      "residenceCountry": "beneficiaryResidenceCountry"
    },
    "paymentInformation": {
      "amountInFigures": 22.12,
      "amountInWords": "twenty two euro twelve cents",
      "currency": "EURO",
      "bankFee": 1.14,
      "valueDate": "12 03 2021",
      "paymentType": "somePaymentType",
      "paymentDetails": "testPaymentDetails",
      "exchangeRate": 0.89,
      "codeOfExternalPayment": "testCodeOfExternalPayment"
    }
  }
}

4. After POST is send the email will be sent to email addresses in sendTo and transaction id will be returned in response.
You can check the status of the transaction by sending GET request to return URL or by executing GET in transaction controller with returned transaction id
Transaction is saved id H2 embedded database in TRANSACTION table. H2 database console can be accessed by URL:
http://localhost:8080/h2-console/login
Connection details:
db Url: jdbc:h2:mem:test
username: test
password: test