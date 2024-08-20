# MovieApp

`MovieApp` is an Android application built using Jetpack Compose, designed to display a list of movies and their details. The app features a home screen where movies are listed, and a details screen for each movie, providing an enhanced user experience. The app leverages modern Android development tools and libraries, such as Compose Material3, Coil for image loading, and a custom navigation setup.

## Features

- **Home Screen:** Displays a list of movies in a scrollable `LazyColumn`.
- **Movie Details Screen:** Each movie item can be clicked to navigate to a detailed view with more information about the movie.
- **Custom Theming:** Uses Material3 and a custom theme for a modern UI.
- **Image Loading:** Efficient image loading with Coil, including transformations like circular cropping and crossfade animations.
- **Multi-Screen Navigation:** Smooth navigation between the home screen and the details screen.

## Project Structure

- **MainActivity:** The entry point of the application. It sets the content view and initializes the app's navigation.
- **MyApp:** A Composable function that applies the custom theme and renders the content.
- **MovieRow:** A composable that represents a single row in the movie list, including an image, title, and additional details.
- **MovieNavigation:** Handles the navigation between the home screen and the details screen.
- **HomeScreen:** Displays the list of movies.
- **DetailsScreen:** Displays detailed information about a selected movie.

## Screenshots

Here are some screenshots of the app in action:

- **Home Screen:**
  ![Home Screen](https://github.com/KushagraPatni/MovieApp/blob/main/HomeScreen.jpg)

- **Details Screen:**
  ![Details Screen](https://github.com/KushagraPatni/MovieApp/blob/main/DetailsScreen.jpg)

## Getting Started

### Prerequisites

- Android Studio Flamingo or later
- Kotlin 1.8.0 or later

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/movieapp.git
