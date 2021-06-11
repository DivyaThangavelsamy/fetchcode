# fetchcode

This application has screen which displays two sections

1. Response code - response from api server
2. fetch count - Number of times reponse code fetched throught app lifecycle


Dependency:

API server with response 

http://localhost:8000/

{
"next_path": "http://localhost:8000/377f639e-caa3-11eb-8d8f-acde48001122/"
}

http://localhost:8000/377f639e-caa3-11eb-8d8f-acde48001122/

{
"path": "377f639e-caa3-11eb-8d8f-acde48001122",
"response_code": "36236a8d-d31b-4b72-9d67-c26699fb249b"
}


Change the URL of the API server in the code 

https://github.com/DivyaThangavelsamy/fetchcode/blob/master/app/src/main/java/com/example/fetchcode/data/api/Constants.kt#L5


Output:

![alt text](https://user-images.githubusercontent.com/58258200/121676098-25a9c200-caac-11eb-914a-d223a5edd75c.png?raw=true)



