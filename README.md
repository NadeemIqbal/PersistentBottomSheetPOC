# Persistent Bottom Sheet POC

A sample Android application demonstrating the use of persistent bottom sheets with navigation.

## Setup

1. Clone the repository
2. Copy `local.properties.template` to `local.properties`
3. Add your Google Maps API key to `local.properties`:
   ```
   MAPS_API_KEY=your_api_key_here
   ```
4. Build and run the project

## Security Note

The Google Maps API key is stored in `local.properties` which is not tracked by git. This prevents the API key from being exposed in the public repository. Each developer needs to add their own API key to their local copy of `local.properties`.

## Features

- Persistent bottom sheet with 50% max height and 25% peek height
- Navigation between fragments inside the bottom sheet
- Google Maps integration 