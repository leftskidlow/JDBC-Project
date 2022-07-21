#Workspace Review

### Task 1

<details>
  <summary>Review the Models</summary>

Navigate to the `models` folder. In this package, there are three different files:

- **User.java**
- **Post.java**
- **Comment.java**

Each of these models represents one of the core objects that will be used in both the application and saved into the database. The files are thoroughly documented, take some time to familiarize yourself with the classes.
</details>

###Task 2

<details>
  <summary>Review the View Models</summary>

We have to view models in this project, **CommunityNewsForum.java** and **MainThread.java**.

The `CommunityNewsForum` class handles all of the logic for this part of the program, from setting up the user interface to displaying posts and menus.

The `MainThread` class simply contains the `main` method and would be where you could merge multiple other view models to handle other aspects of the program that are not yet developed, say maybe a `UserChat` feature or a `MarketPlace`. For our scope though, it will simply `.start()` the `CommunityNewsForum`.

</details>

### Task 3

<details>
  <summary>Review the Services</summary>

These files contain the logic that will be used to connect your `CommunityNewsForum` to the SQLite database that will serve as our backend data storage solution. These files are also heavily documented.

Most of your work will be contained in **PostService.java**

</details>