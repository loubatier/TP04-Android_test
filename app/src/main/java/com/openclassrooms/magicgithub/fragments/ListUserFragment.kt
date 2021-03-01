package com.openclassrooms.magicgithub.ui.user_list.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.repository.UserRepository
import com.openclassrooms.magicgithub.ui.user_list.ListUserActivity
import com.openclassrooms.magicgithub.adapters.UserListAdapter
import com.openclassrooms.magicgithub.databinding.ActivityListFragmentBinding

class ListUserFragment:Fragment(), UserListAdapter.Listener {
    @VisibleForTesting
    lateinit var repository: UserRepository
    private lateinit var binding: ActivityListFragmentBinding

    // FOR DESIGN ---
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    // FOR DATA ---
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = ActivityListFragmentBinding.inflate(inflater, container, false)
        configureFab()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    // CONFIGURATION ---
    private fun configureRecyclerView() {
        recyclerView = binding.activityListUserRv
        adapter = UserListAdapter(this)
        recyclerView.setAdapter(adapter)
    }

    private fun configureFab() {
        fab = binding.activityListUserFab
        fab.setOnClickListener { view: View? ->
            repository.generateRandomUser()
            Log.d("appDebug",repository.users.toString())

            loadData()
        }
    }

    private fun loadData() {
        adapter.updateList(repository.users)
    }

    // ACTIONS ---
    override fun onClickDelete(user: User) {
        Log.d(ListUserActivity::class.java.name, "User tries to delete a item.")
        repository.deleteUser(user)
        loadData()
    }
}