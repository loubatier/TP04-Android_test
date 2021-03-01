package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User

class FakeApiService : ApiService {
    private val _users = FakeApiServiceGenerator.FAKE_USERS

    /**
     * Return a list of [User]
     * Those users must be generated by [FakeApiServiceGenerator]
     */
    override fun getUsers(): List<User> {
        val usersCopy = mutableListOf<User>()
        usersCopy.addAll(_users)
        return usersCopy
    }

    /**
     * Generate a random [User] and add it [FakeApiService.users] list.
     * This user must be get from the [FakeApiServiceGenerator.FAKE_USERS_RANDOM] list.
     */
    override fun generateRandomUser() {
        _users.add(FakeApiServiceGenerator.generateRandomUser())
    }

    /**
     * Delete a [User] from the [FakeApiService.users] list.
     */
    override fun deleteUser(user: User) {
        _users.remove(user)
    }
}
