# Tala Loan App

A tala loan app created using jetpack compose

## Features
The app has the following features:
1. View a list of your loans
2. View details of a selected loam

## Architecture
The app is built using the ``Clean architecture + MVVM`` and separated into different modules:
- ``core-data``: parse locale and loans data from json and expose the data to other modules
- ``core-design`` : include all design related material in jetpack compose e.g color, shape, themes
- ``core-utils``: include utils shared across the app
- ``core-resources``: include all resources used in the app e,g drawables, strings
- ``feature-loans``: view list of loans
- ``feature-selected-loans``: view details and action of selected loan

## Getting Started
Clone the app and run
```kotlin
Clone and build using android studio
