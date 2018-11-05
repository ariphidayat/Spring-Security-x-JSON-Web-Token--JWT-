# Spring Security OAuth2 x JSON Web Token (JWT) Example

This application is full implementation of Spring Security OAuth2 to make use of JSON Web Token (JWT). For example Spring 
OAuth2 implementation, please visit this repository [springmvc-oauth2-example](https://github.com/ariphidayat/springmvc-oauth2-example) 

JSON Web Token (JWT) is an open standard [RFC 7519](https://tools.ietf.org/html/rfc7519) method for representing claims 
securely transmitting information between parties as a JSON object. This object can be verified and trusted because 
it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA.

                                                 +---------------+
         +------- Authorization Grant ---------->|               |
         |                                       | Authorization |
         |    +---------- JWT Token ------------<| Server        |
         ^    v                                  |               |
     +-------------+                             +---------------+
     |             |
     | User Agent/ |
     | Client      |
     |             |
     +-------------+                             +---------------+
         ^    v                                  |               |
         |    +---- API Calls x JWT Token ------>|    Resource   |
         |                                       |    Server     |
         +-------- Protected Resource ----------<|               |
                                                 +---------------+
             
             
     Note : The Authorization Server will provide the JWT Token to the User/Client. 
            With the JWT Token, the User/Client can then safely communicate with 
            the Resource Server.

The token is composed of a header, a payload, and a signature with periods (.) separating them. a JWT is just a string with the following format:

        header.payload.signature
        
*   **Header**, typically consists of two parts: the type of the token, which is JWT, and the hashing algorithm 
    being used, such as HMAC SHA256 or RSA. For example:
    
    
        {
          "alg": "HS256",
          "typ": "JWT"
        }
            
*   **Payload**, which contains the claims. Claims are statements about an entity (typically, the user) and 
    additional metadata. For example the authorization server creates a JWT with username information stored inside it.
    
    
        {
          "sub": "1234567890",
          "name": "Arip Hidayat",
          "iat": 1516239022
        }
     
*   **Signature**, is created by taking the header and payload together then passing it through the specified algorithm
    along with a known secret. For example using HMAC SHA-256, the signature will be created in the following way:
    
    
        HMACSHA256(
            base64UrlEncode(header) + "." +
            base64UrlEncode(payload),
            secret
        )

*You can try creating your own JWT through your browser at [jwt.io](https://jwt.io/)*


## Run Application

        $ mvn spring-boot:run

## How Application Works

* Request access token : 

        $ curl client:s3cret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=passw0rd 

* Application will give you JSON response with access token :

		{
		    "access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXJpcF9oaWRheWF0Il0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU0MTQzMjk4NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI0NWU1NzllMi01YmNmLTRkODctOWM2OC0wZmU1NjM3Yjc5ZTEiLCJjbGllbnRfaWQiOiJjbGllbnQifQ.8Vkpi3IpTDV3uaOdbXmVWalyeaiu-h25eL0FltZQ5f8",
		    "token_type":"bearer","expires_in":43198,
		    "scope":"read write",
		    "jti":"45e579e2-5bcf-4d87-9c68-0fe5637b79e1"
		}

* Access a resource with header parameter : 

        $ curl localhost:8080?name=Arip -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXJpcF9oaWRheWF0Il0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU0MTQzMjk4NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI0NWU1NzllMi01YmNmLTRkODctOWM2OC0wZmU1NjM3Yjc5ZTEiLCJjbGllbnRfaWQiOiJjbGllbnQifQ.8Vkpi3IpTDV3uaOdbXmVWalyeaiu-h25eL0FltZQ5f8"

* Application will give JSON response :

		{
		    "email":"admin@arip.id",
		    "name":"Admin",
		    "address":"Anywhere"
		}

> Since JWT are signed and encoded only, and since JWT are not encrypted, JWT do not guarantee any security for 
> sensitive data.


> It should also be noted that JWT should be sent over HTTPS connections. Having HTTPS helps prevents unauthorized 
> users from stealing the sent JWT by making it so that the communication between the servers and the user cannot be 
> intercepted.

> Also, having an expiration in your JWT payload, a short one in particular, is important so that if old JWT 
> ever get compromised, they will be considered invalid and can no longer be used.


## References
https://tools.ietf.org/html/rfc7519

https://jwt.io/

https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/

https://medium.com/vandium-software/5-easy-steps-to-understanding-json-web-tokens-jwt-1164c0adfcec
