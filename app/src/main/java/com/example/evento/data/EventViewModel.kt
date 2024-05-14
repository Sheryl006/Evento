package com.example.evento.data
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.evento.models.Events
import com.example.evento.models.Upload
import com.example.evento.navigation.ROUTE_EVENT_TYPE
import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_USER_LOGIN
import com.example.evento.navigation.ROUTE_VIEW_UPLOADS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class EventViewModel (var navController:NavHostController,var context: Context) {
     var authRepository: AuthViewModel
    val progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_USER_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait....")

    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun saveEvent(
        eventName: String,
        location: String,
        description: String,
        price: String

    ) {
        var id = System.currentTimeMillis().toString()
        var eventData = Events(eventName, location, description, price, id)
        var eventRef = FirebaseDatabase.getInstance().getReference()
            .child("Events/$id")
        progress.show()
        eventRef.setValue(eventData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Hosting event successful", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_FIND_EVENTS)
            } else {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_EVENT_TYPE)
            }
        }

    }

    fun viewEvent(
        event: MutableState<Events>,
        events: MutableList<Events>

    ): MutableList<Events> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Events")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                events.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Events::class.java)
                    event.value = value!!
                    events.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return events
    }


    fun deleteEvents(id: String) {
        val delRef = FirebaseDatabase.getInstance().getReference()
            .child("Events/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Event Deleted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun updateEvent(
        eventName: String,
        location: String,
        description: String,
        price: String,
        id: String
    ) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Events/$id")
        progress.show()
        var updateData = Events(eventName, location, description, price, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun saveEventWithImage(
        name: String,
        location: String,
        description: String,
        price: String,
        filePath: Uri
    ) {
        var id = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
        progress.show()

        storageReference.putFile(filePath).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                // Proceed to store other data into the db
                storageReference.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var houseData = Upload(
                        name, location,
                        description, price, imageUrl, id
                    )
                    var dbRef = FirebaseDatabase.getInstance()
                        .getReference().child("Uploads/$id")
                    dbRef.setValue(houseData)
                    Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_VIEW_UPLOADS)
                }
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }



    fun viewUploads(
        upload: MutableState<Upload>,
        uploads: SnapshotStateList<Upload>
    ): SnapshotStateList<Upload> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                uploads.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Upload::class.java)
                    upload.value = value!!
                    uploads.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return uploads
    }







}



