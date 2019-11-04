package com.ebc.ipnapplication.ui.login.view

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebc.ipnapplication.R
import com.ebc.ipnapplication.data.database.repository.post.Post
import com.ebc.ipnapplication.ui.base.view.BaseActivity
import com.ebc.ipnapplication.ui.login.interactor.LoginMVPInterActor
import com.ebc.ipnapplication.ui.login.presenter.LoginMVPPresenter
import com.ebc.ipnapplication.utils.extension.AppConstants
import com.ebc.ipnapplication.utils.extension.CommonUtil
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMVPView {

    @Inject
    internal lateinit var presenter: LoginMVPPresenter<LoginMVPView, LoginMVPInterActor>
    @Inject
    internal lateinit var postsAdapter: PostsAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        post_recycler_view.layoutManager = layoutManager
        post_recycler_view.itemAnimator = DefaultItemAnimator()
        post_recycler_view.adapter = postsAdapter
 //       if (CommonUtil.verifyAvailableNetwork(this))
            presenter.loadUserPosts()
  //      else
     //       presenter.loadCachedUserPosts()

    }


    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMainActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(
                this,
                "WrongMail",
                Toast.LENGTH_LONG
            ).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(
                this,
                "WrongMail",
                Toast.LENGTH_LONG
            ).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(
                this,
                "WrongMail",
                Toast.LENGTH_LONG
            ).show()
            AppConstants.LOGIN_FAILURE -> Toast.makeText(
                this,
                "WrongMail",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun displayUsersList(usersList: List<Post>) {
        postsAdapter.addBlogsToList(usersList)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
