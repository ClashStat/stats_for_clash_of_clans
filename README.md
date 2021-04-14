Original App Design Project - README Template
===

# Clash Stats

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This Android App will utilize the public API documentations of Clash of Clans which is a mobile gaming app. The functionality of this app focuses on showing the user a comprehensive overview of all their current game statistics from Home-Village and Builder-Village.  

### App Evaluation
- **Category:** Mobile Game Status App
- **Mobile:** This app is mainly for a Mobile phone since it will require the user to input the device IP address and the mobile game's unique ID. However this may be also remotely used as a web browser application
- **Story:** This app requires the user to first have a Clash of Clans account to be able to access the app using their unique game ID. On signing in the user will be able to see all the achievements, troops, heroes, current building levels etc., in both, the Home Village and the Builder Village.
- **Market:** Any person that has plays Clash of Clans will be able to utilize this application.
- **Habit:** Due to the magnitude of information and items on the actual game, it is tough to keep a comprehensive check on what is which level and what needs upgrade. This app can provide that and it can be used as much or as little the user likes to review accurate account information.
- **Scope:** Applications of this kind usually sum up the player statistics and allows the user to remotely upgrade items in the game in real time.

## Product Spec

### 1. User Stories
- [x] The user is able to sign-in using the #clashOfclansID\
- [x] The user is able to see Profile info for the account they logged in with
- [x] The user is able to see the logo for the currentPlayerLeague and currentPlayerClan for visualization. 
- [ ] User is able to log-out
- [ ] The user can persistently stay logged-in unless they log-out manually
- [x] There are distributed fragments that show user statistics
- [ ] The user can scroll to visualize data in Achivement Fragment
- [x] The fragment in which the user is currently, changes color


### 2. Screen Archetypes
* Login Screen
   * The user must enter their unique Clash of Clans ID, starting with a #
* Profile Page
   * Once the user has logged in, he/she can see their own Name, ID, Game Level, Townhall levels, Clan Name and Rank, Numbers of VSBattles won, etc. The user may checkout the Troops page or Achievements page
* Troops
   * On this fragment of the app, the user will be able to see all the Heroes that he/she has along with their level, followed by all the unlocked barracks and dark barracks troops along with their levels. The user may then click on the Achievements option on the bottom right corner of the app.
* Achievements
   * This fragment of the app shows the user all the Game-Creator made achievements with an accurate representation of how close the user is to completing them or how many have already been completed or remain pending. 

### 3. Navigation

**Tab Navigation** (Tab to Screen)
*  Login Page
*  Profile Page
*  Troops
*  Achievements

**Flow Navigation** (Screen to Screen)

* Login screen -> input the unique game id
* Profile page -> player's profile information 
* Troops -> all the player troops and their levels including their heroes
* Achievements -> all the user achievements in the game and success rate
* Logout -> log out of the app and go back to the Login page

## Wireframes
<img src="/Walkthrough/wireframes.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="/Walkthrough/digital_wireframe.png" width=600>

### [BONUS] Interactive Prototype
<img src="/Walkthrough/Unit_9.gif" title='Video Walkthrough' width='' alt='Video Walkthrough' />

## Schema 
[This section will be completed in Unit 9]

### Models
#### Player
|      Property     |    Type   |                 Description                |
|-------------------|-----------|--------------------------------------------|
|        Tag        |String     |      The user's gamer tag                  |
|        Name       |String     |      The user's account name               |
|      Trophies     |Integer    |      The user's total trophies             |
|    townHallLevel  |Integer    |      The Home Village townhall level       |
|  builderHallLevel |Integer    |      The Builder Village townhall level    |
|       league      |File Object|      The warrior league the player is in   |
|       clan        |File Object|      The clan's name                       |

#### Troops
| Property  |  Type | Description  |
|-----------|-------|--------------|
|   |   |   |
|   |   |   |
|   |   |   |

#### Achievement
| Property  |  Type | Description  |
|-----------|-------|--------------|
|   |   |   |
|   |   |   |
|   |   |   |

### Networking
#### List of Network Requests by Screen
- Home Screen
    - (Update/PUT) Analyze gamer tag to allow login

- Profile Screen
    - (Read/GET) Get user trophies
    - (Read/GET) Get user townhall level
    - (Read/GET) Get user builderhall level
    - (Read/GET) Get user league
    - (Read/GET) Get user clan
- Troops Screen
- Achievements Screen 
