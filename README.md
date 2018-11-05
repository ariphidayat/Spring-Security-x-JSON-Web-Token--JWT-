# Spring Security OAuth2 x JSON Web Token (JWT) Example

JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.

## Run Application

`$ mvn spring-boot:run`

## How Application Works

* Request access token : 

        $ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=password 

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
			"success":true,
			"page":"admin",
			"user":"admin"
		}


## References
https://tools.ietf.org/html/rfc7519

https://jwt.io/
