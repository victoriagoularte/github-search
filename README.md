# github-search
Project to explore Android features.

## Features
**Github Search** displays a list of repositories from Github API ordered by stars count. Users can see in items of list: the owner name, the avatar's owner, the amount of forks and stars.

### Screenshots
![loading](https://user-images.githubusercontent.com/22014773/228102510-137fba85-811b-4812-b73a-3eb02a6d5ab3.png) ![repository-list](https://user-images.githubusercontent.com/22014773/228102542-e9f3379d-ede7-40a8-8ced-9e0e17e646c9.png)

## Main technologies / Frameworks
- Retrofit
- Coroutines
- Flow
- Paging 3
- Hilt
- Gradle Kts / Gradle version catalog
- Material 3
- Compose
- Compose Navigation
- Coil
- Clean Architecture

## Architecture

Looking for low coupling and high cohesion as recommended [here](https://developer.android.com/topic/modularization/patterns). The architecture is grouped into modules by layer and feature.

### App modules

<p align="center">
  <img src="https://user-images.githubusercontent.com/22014773/228105701-f1255ea4-61d8-440c-b5e3-4b3d010b9b86.png">
</p>

### Module to module communication


<p align="center">
  <img src="https://user-images.githubusercontent.com/22014773/228105803-275b045c-3754-4f3c-871d-9d09d3c5f4c0.png">
</p>

## Next steps

✅ cache of reposository list
- Feature about Users
