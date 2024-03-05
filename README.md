This is a currency conversion and calculation application. 

currency_exchange services have been created more than once. It is called by the currency_conversion service with the load balancer.

-ports for applications-
currency_exchange : 8000,8001
currency_conversion: 8100
eureka server(naming server): 8761
spring cloud gateway server: 8765
