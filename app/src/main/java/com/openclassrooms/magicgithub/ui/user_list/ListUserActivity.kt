package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.openclassrooms.magicgithub.adapters.UserListAdapter
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.repository.UserRepository
import com.openclassrooms.magicgithub.ui.user_list.fragments.ListUserFragment

class ListUserActivity : AppCompatActivity(){
    @VisibleForTesting
    lateinit var repository: UserRepository
    private lateinit var binding: ActivityListUserBinding

    // FOR DESIGN ---
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    // FOR DATA ---
    private lateinit var adapter: UserListAdapter

    // OVERRIDE ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(ListUserFragment())
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, fragment)
            addToBackStack(null)
        }.commit()
    }



}