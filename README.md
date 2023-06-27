# Compose Navigation Dev Talk


# Navigation Architecture Component

The Navigation Architecture Component is a part of the Android Jetpack libraries that provides a set of tools and components to implement navigation in your Android application. It promotes a declarative and modular approach to define and manage navigation within your app.

The Navigation Architecture Component consists of the following key elements:

## Navigation Graph

The Navigation Graph is a visual representation of your app's navigation flow. It consists of destinations and actions that link these destinations together. Destinations represent individual screens or fragments, while actions define the connections between them.

To define a navigation graph in code, you can create a graph using the `navigation` DSL:

```
val navController = rememberNavController()
NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomeScreen(navController) }
    composable("details/{itemId}") { backStackEntry ->
        val itemId = backStackEntry.arguments?.getString("itemId")
        DetailsScreen(itemId)
    }
}
```
In this example, we define a navigation graph with two destinations: "home" and "details/{itemId}". The "details/{itemId}" destination accepts a dynamic argument called "itemId" which can be passed between destinations.

## Nav Host

The Nav Host is a container that hosts the navigation graph. It acts as a canvas where you can draw your app's navigation flow. Within an activity, the Nav Host is the container where destinations are shown. It provides a space for displaying the appropriate screens based on the user's navigation actions. Nav Hosts can be either global, displaying the entire app's navigation flow, or single destination views, showing only a specific part of the app's navigation.

To create a Nav Host in your Compose UI, you can use the `NavHost` composable:

```
val navController = rememberNavController()
NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomeScreen(navController) }
    composable("details/{itemId}") { backStackEntry ->
        val itemId = backStackEntry.arguments?.getString("itemId")
        DetailsScreen(itemId)
    }
}
```
In this example, the `NavHost` composable sets up the Nav Host with the provided navigation graph, using `rememberNavController()` to create an instance of the `NavController`.

## Nav Controller

The Nav Controller is responsible for managing navigation within the Nav Host. It keeps track of the current destination and handles navigation actions, such as moving to a new screen or going back to the previous screen. The Nav Controller is the bridge between the Nav Host and the destinations. It listens to navigation events and performs the necessary operations to update the UI accordingly.

To navigate between destinations using the Nav Controller, you can use the `navigate()` function:

```
navController.navigate("details/123")
```

This code snippet navigates to the `details/{itemId}` destination with the argument "123". The Nav Controller handles the navigation and updates the UI accordingly.


### Passing Arguments between Compose Nav Destinations

When navigating between destinations in Jetpack Compose Navigation, you often need to pass arguments along. Compose Navigation provides a convenient and type-safe way to accomplish this.

### Defining Arguments

To define arguments for a destination, you can use the `arguments` parameter of the `composable` function:

```
composable(
	route = "details/{itemId}",  
	arguments = listOf(  
        navArgument("itemId") {   
			type = NavType.StringType   
		}  
	)  
) { backStackEntry ->  
  val itemId = backStackEntry.arguments?.getString("itemId")  
    DetailsScreen(itemId)  
}
```
In this example, we define an argument "itemId" of type `String` for the "details/{itemId}" destination. The `navArgument` function is used to specify the argument with its name and type. In this case, we set the type to `NavType.StringType`.

### Navigating with Arguments

To navigate to a destination with arguments, you can use the `navigate` function and provide the route along with the argument values:

```
navController.navigate("details/123")
```

In this example, we navigate to the "details/{itemId}" destination with the argument value "123". The argument value is appended to the route, separated by a slash.

### Accessing Arguments in Composables

To access the arguments passed to a destination in its corresponding composable, you can use the `NavBackStackEntry` provided by the navigation library:

```
@Composable
fun DetailsScreen(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val arguments = navBackStackEntry.value?.arguments
    val itemId = arguments?.getString("itemId")

    // Use the itemId in your composable
}
```

In this example, we retrieve the current `NavBackStackEntry` using `currentBackStackEntryAsState()` and access the arguments using `arguments`. We can then extract the specific argument value, in this case, "itemId", using `getString()`.

## Repository Pattern

The Repository Pattern is a software design pattern that helps manage data access and provides a clean separation between the data layer and the rest of the application. When passing arguments in Compose Navigation, it is recommended to follow the Repository Pattern approach. This ensures that the navigation layer remains decoupled from the data source layer, promoting code maintainability and testability.
