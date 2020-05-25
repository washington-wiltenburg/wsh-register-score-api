# REGISTER SCORE API

- Documentation API:

    http://localhost:8080/register-score/swagger-ui.html

- Initialize API
    
    - mvn spring-boot:run
    - create mock qtd to users in score API, endpoint: http://localhost:8080/register-score/api/create/random/{PARAM}
    - import json to Postman 
    
- Endpoints:

    - create-score: 
    
            http://localhost:8080/register-score/api/create    
            Method: Post
            Payload Example: 
            { 
            	"points" : 100 , 
            	"userId" : 1
            }
            
    - actual-position:
        
            http://localhost:8080/register-score/api/actual/position/1
            Method: Get
    
    - high-score-lists
            
            http://localhost:8080/register-score/api/high/lists
            Method: Get
            
    - create-score-random
    
            http://localhost:8080/register-score/api/create/random/500
            Method: Post        
                            
- Postman
    
    - Locations json import: 
    
            /resources/collections/register-score-api.postman_collection.json                                    