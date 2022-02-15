# Flixter
Flixter is an android app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

### User Stories

- [x] User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.
- [x] Views should be responsive for both landscape/portrait mode.
- [x] In portrait mode, the poster image, title, and movie overview is shown.
- [x] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.
- [x] Display a nice default placeholder graphic for each image during loading
- [x] Improved the user interface by experimenting with styling and coloring.
- [x] Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] Allow video posts to be played in full-screen using the YouTubePlayerView.
- [x] Implement a shared element transition when user clicks into the details of a movie (1 point). 
- [x] Trailers for popular movies are played automatically when the movie is selected (1 point).
- [x] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
- [x] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [x] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

<img src="https://i.imgur.com/lf4ZYjh.gif" width=250><br>
---
<img src="https://i.imgur.com/zcWIGyp.gif" width=250><br>
---
<img src="https://i.imgur.com/H7bxrhb.gif" width=500><br>
---
<br>


### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
