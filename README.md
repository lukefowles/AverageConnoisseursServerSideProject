# AverageConnoisseursServerSideProject

We are the average connosseurs, a team consisting of BNTA cohort 4 members Aaishah, Jess, Luke and Yonis. For our server-side project we have created an API which allows users to interact with a sample restaurant database in a variety of ways. This idea was inspired by the Food Recommendations channel in the cohort discord, and we hope to add cohort member's favourite restaurants to our sample database. Below are the key aims of our MVP.


# MVP

- Customers are able to create an account which is stored to the customer database.
- Customers are able to edit or delete their account.
- Customers are able to view restaurants and related information.
- Customers are able to filter restaurants according to criteria.
- Customers can order restaurants by average rating.
- Customers can add a restaurant to the database (We will also include functionality to edit and remove restaurants, this in practise would be for admins).
- Customers can review a restaurant, giving it a rating out of five and a comment. When review is added, the average rating of the restaurant should be recalculated.
- Customers have their own wishlist within the API, to include their favourite restaurants or restaurants they would like to go to. Customers can add and remove from the wishlist.

# Extension to MVP: 

If we have additional time, here are some more aims we would like to work on:

- Randomiser that chooses a restaurant for customers based on their criteria or no criteria whatsoever (lucky dip).
- Create a booking system for customers that allows them to book a restaurant for a certain day.
- The program should be able to recognise when a restaurant has exceeded its maximum customers for a given day.
- Add password functionality, so that only the relevant customer is able to edit/view their information.
- Implement machine learning method for restaurant reccomendations.

# Tech Stack

The BNTA project brief was that our project be entirely back-end in this instance. Our project is a Spring Boot Application which connect to an SQL (PostgresSQL) database for the persistence layer, using JDBCtemplate, Hikkari datasource and FlywayDB for database migration. For unit-testing, we have used a combination of JUnit, AssertJ and mockito. The API platform we used was ThunderClient.

# How to Use Project

To use our project, clone our repository from Github and open in your preferred IDE. In order to connect to your own database, change the application.properties file to include the name of your desired database, as well as your username and password.

# Project Structure

Within our project we have five POJOs, Customer, Restaurant, RestaurantCriteria, Wishlist and Review. These POJos are what can be passed via JSON through the API and dictate the transfer of information from front to back-end. Associated controller, service and repository beans have been created for the Customer, Restaurant, Review and Wishlist classes, allowing CRUD operations to occur. Below are some important points of note:

-In order to add a customer to the database, you have to provide a customer in JSON format to the API. This value of this customer's id will be changed on addition to the SQL database. In order to improve our project, we could have implement a method within the customer service class that returns the new id when a customer is created (for instance, by querying the sql database for the email address).

-The RestuarantCriteria class is used solely to enable for querying of the restaurantDatabase. It takes all possible search parameters at once, which can pose a problem if one would only want to put in certain selection constraints. This can be sidestepped choosing default values for the search parameters which do not set constraints (i.e. null)

-An instance of our wishlist class represents one item on a customer's wishlist, and not the entire wishlist itself. For example, the method which returns a customers wishlist, actually returns a list of wishlisht objects (List<Wishlist>).

  
Below we have attached our class diagrams and entity relationship diagrams for reference:
  
  
# Credits
  
  Project collaborators: Aaishah Sharif, Jessica Morse, Luke Fowles, Yonis Abdulahi


