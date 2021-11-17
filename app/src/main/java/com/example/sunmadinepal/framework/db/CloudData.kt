package com.example.sunmadinepal.framework.db

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference




class CloudData : AppCompatActivity()  {

    lateinit var storage: FirebaseStorage

    var storageRef = storage.reference

    var pathReference = storageRef.child("images/stars.jpg")

    // Create a reference to a file from a Cloud Storage URI
    var gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg")


    // Create a reference from an HTTPS URL
    // Note that in the URL, characters are URL escaped!
    var httpsReference =
        storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg")
}