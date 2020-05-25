# REGISTER SCORE API

- Documentation API:

    http://localhost:8080/register-score/swagger-ui.html
    
- Endpoints:

    - create score: 
    
            http://localhost:8080/register-score/api/create    
            Method: Post
            Payload Example: 
            { 
            	"points" : 100 , 
            	"userId" : 1
            }
            
    - actual position:
        
            http://localhost:8080/register-score/api/actual/position/1
            Method: Get
    
    - high lists
            
            http://localhost:8080/register-score/api/high/lists
            Method: Get
                            
- Postman
    
    - Locations json import: 
    
            /resources/collections/register-score-api.postman_collection.json                                    