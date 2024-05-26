The solution of two problems is in two folders

## Question1 : moovup-backend

### Tech used
1. Koltin
2. Gradle

### How to Run
1. Install java 17
2. go the moovup-backend directory
3. Run command ``` ./gradlew run``` to get result
4. Run command ``` ./gradlew test``` to run test cases


## Question2 : moovup-frontend
### Tech used
1. Vue
2. Vue Router 
3. leaflet (for map)
4. Jtest and Vue Test Utils  


### How to Run
1. Install node
2. Run command ```npm install``` to install package
3. Run command ```npm run dev``` to start the server
4. Run command ```npm run test:unit``` to run the test case


### Remarks
1. I find that some data lack of latitude or longitude, so if the data lack one of these, it will not be render 
2. Making test lifecycle work needs a lot of time for me and I am afraid there is not enough time of making test case works so I give us on this part but let me illustrate the idea behind it

2. The idea is to make four user requirements meets
    1. Retrieve list of people from the API and Display list of people.
        1. Assert that the number of rows of router-link match the list size from the api
        2. Assert that the dom element contains the same info of the API
    2. Show details when user select an item in the list and Add marker on the map based on the provided latitude/longitude in location.
        1. Assert the map is render by checking render function is called
        2. Assert the market is places by checking marking function is called
