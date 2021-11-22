package com.example.sunmadinepal.framework.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmadinepal.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class CloudData : AppCompatActivity() {

    lateinit var storage: FirebaseStorage

    // storageRef was previously used to transfer data.
    private lateinit var storageRef: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lifecycle_demo)
    }

    // [START storage_download_lifecycle]
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // If there's a download in progress, save the reference so you can query it later
        outState.putString("reference", storageRef.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // If there was a download in progress, get its reference and create a new StorageReference
        val stringRef = savedInstanceState.getString("reference") ?: return

        storageRef = storage.getReferenceFromUrl(stringRef)

        // Find all DownloadTasks under this StorageReference (in this example, there should be one)
        val tasks = storageRef.activeDownloadTasks

        if (tasks.size > 0) {
            // Get the task monitoring the download
            val task = tasks[0]

            // Add new listeners to the task using an Activity scope
            task.addOnSuccessListener(this) {
                // Success!
                // ...
            }
        }
    }


}