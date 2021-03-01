package com.openclassrooms.magicgithub.ui.user_list

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User


class ListUserViewHolder(val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {
    // FOR DESIGN ---
    private val avatar: ImageView
    private val username: TextView
    private val deleteButton: ImageButton
    fun bind(user: User, callback: UserListAdapter.Listener) {

        Glide.with(itemView.context)
                .load(user.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(avatar)
        username.text = user.login
        deleteButton.setOnClickListener { view: View? -> callback.onClickDelete(user) }
    }

    init {
        avatar = binding.itemListUserAvatar
        username = binding.itemListUserUsername
        deleteButton = binding.itemListUserDeleteButton
    }
}