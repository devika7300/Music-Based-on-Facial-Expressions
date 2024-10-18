# 🎵 Music Based on Facial Expressions

An Android app that detects a user's mood from their facial expressions and provides personalized music suggestions. Using Convolutional Neural Networks (CNN) and integrating the Spotify API, the app aligns music choices with the detected mood, enhancing user engagement and offering a unique listening experience.

---

## 📜 Project Overview

The project aims to:
- Detect mood from facial expressions using a trained CNN model built with **TensorFlow** and **Keras**.
- Provide mood-based personalized music playlists by integrating the **Spotify API**.
- Improve user engagement by offering a seamless and interactive music recommendation system.

---

## 🚀 Key Features

- **Mood Detection**: Utilized CNN for facial expression recognition, achieving a model accuracy of 76%.
- **Personalized Playlists**: Integrated Spotify API to suggest mood-aligned music, boosting user engagement by 25%.
- **Continuous Development**: Employed **Git** version control to manage and continuously improve the app's features.
  
---

## 🛠 Technologies Used

- **Machine Learning Frameworks**: TensorFlow, Keras (for building CNN)
- **Languages**: Java (for Android development),  XML (for UI design)
- **Backend**: Firebase (for authentication and data management)
- **APIs**: Spotify API (for music recommendations)
- **Version Control**: Git (for tracking development progress)

---

## 🎯 How It Works

1. **Mood Detection**: 
   - The app uses a CNN model to analyze facial expressions captured through the device camera.
   - Based on the expression, it classifies the mood into categories such as happy, sad, neutral, etc.

2. **Personalized Music Recommendation**:
   - Once the mood is detected, the app connects to Spotify's API to retrieve playlists that match the user's current mood.
   - Users can immediately start listening to music aligned with their emotional state.

3. **User Interface**:
   - The UI was built using **XML** and provides a seamless user experience with real-time mood detection and music recommendations.

---

## 🛠 How to Run the Project

1. **Clone the Repository**: Clone the repository to your local machine.
2. **Set Up Firebase**: Ensure Firebase is properly set up for authentication and data management.
3. **Configure Spotify API**: Add your Spotify API credentials to the app for music recommendation features.
4. **Run on Android Studio**: Open the project in **Android Studio**, and run the app on a compatible Android device.

---

## 📈 Results

- **Model Accuracy**: The CNN model achieved an accuracy of 76% in detecting moods.
- **User Engagement**: Personalized playlists increased user engagement by 25%, providing a more immersive music experience.
  
---

## 🔮 Future Enhancements

- **Improved Accuracy**: Fine-tune the CNN model to achieve higher accuracy in mood detection.
- **Expanded Music Options**: Integrate other music services like Apple Music for wider music selection.
- **Multi-Mood Detection**: Introduce support for detecting multiple emotions in complex expressions.
