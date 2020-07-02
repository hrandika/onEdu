package com.hrandika.angular.onedu.ui.gallery

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.ktx.storage
import com.hrandika.angular.onedu.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.io.ByteArrayOutputStream
import java.time.LocalDateTime
import java.util.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var btn = root.findViewById<View>(R.id.button) as Button
        // set on-click listener
        btn.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            print("hello clicked")
//            val myIntent = Intent(activity, profileActivity::class.java)
//            startActivity(myIntent)
            openGalleryForImage()
        }

        return root
    }

    fun loadImage(){
        var storage = Firebase.storage

        val storageRef = storage.reference

    }

    // test function to connect firebase
    fun loadDataFromFirebase() {
        Log.e("Firebase", "start uploading")
        var storage = Firebase.storage

        val storageRef = storage.reference

// Create a reference to "mountains.jpg"
        val mountainsRef = storageRef.child("mountains.jpg")

// Create a reference to 'images/mountains.jpg'
        val mountainImagesRef = storageRef.child("images/mountains.jpg")

// While the file names are the same, the references point to different files
        mountainsRef.name == mountainImagesRef.name // true
        mountainsRef.path == mountainImagesRef.path // false

        // Get the data from an ImageView as bytes

        imageView2.isDrawingCacheEnabled = true
        imageView2.buildDrawingCache()
        val bitmap = (imageView2.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = mountainsRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
            Log.e("firebase upload", "failed")
        }.addOnSuccessListener {
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
//            Log.e("firebase sessing uir", it.uploadSessionUri.toString())
            Log.e("firebase ref", it.metadata?.reference.toString())

//            if(it.metadata?.reference?.downloadUrl?.isSuccessful){
                Log.e("firebase completed", it.metadata?.reference?.downloadUrl?.isComplete.toString())
//                Log.e("firebase download url", it.metadata?.reference?.downloadUrl?.result.toString())
//            }
            // ...
        }.addOnProgressListener{taskSnapshot ->
            val progress = (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
            Log.e("image upload","Upload is $progress% done")
        }.addOnPausedListener {
            println("Upload is paused")
        }
    }
    val REQUEST_CODE = 100

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        print("image loaded")
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            imageView2.setImageURI(data?.data) // handle chosen image
            loadDataFromFirebase()
        }
    }
}