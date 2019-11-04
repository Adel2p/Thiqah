package com.ebc.ipnapplication.ui.login.view

import com.ebc.ipnapplication.data.database.repository.post.Post
import com.ebc.ipnapplication.ui.base.view.MVPView

interface LoginMVPView: MVPView{
    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
    fun displayUsersList(usersList: List<Post>)

}
